package grails.spring.security.sample

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.access.AccessDeniedException

@Secured(['IS_AUTHENTICATED_FULLY'])
class UserController {

    Logger log = LoggerFactory.getLogger(UserController.class);

    def springSecurityService

    def edit() {

        User user = User.get(params.id)

        def loggedInUser = springSecurityService.currentUser

        if (loggedInUser.id != user.id) {
            def message = "User ${loggedInUser} has tried to edit ${user}!"
            log.info(message)
            throw new AccessDeniedException(message)
        }

        log.debug("User ${user} is going to be edit his data!")

        def command = new UserUpdateCommand('id': user.id, 'username': user.username, 'email': user.email)
        render view: 'edit', model: [user: command]
    }

    @Transactional
    def update(UserUpdateCommand command) {

        withForm {

            if (command.id == null) {
                redirect action: 'edit'
            }

            if (command.hasErrors()) {
                render view: 'edit', model: [user: command, id: params.id]
                return
            }

            User user = User.get(command.id)

            if (!user) {
                throw new Exception("Not user found for id ${command.id}")
            }

            def loggedInUser = springSecurityService.currentUser

            if (loggedInUser.id != user.id) {
                def message = "User ${loggedInUser} has tried to edit ${user}!"
                log.info(message)
                throw new AccessDeniedException(message)
            }

            user.properties['email', 'username'] = command.properties

            if (command.password) {
                user.password = springSecurityService.encodePassword(command.password)
            }

            user.save()

            if (user.hasErrors()) {
                log.debug("User data ${user} cant't be stored, due to errors!")
                render view: 'edit', model: [user: user]
                return
            }

            log.info("User data ${user} successfully saved")

            flash.message = message(code: 'userEdit.update.successful', args: '')

            redirect action: 'edit', id: user.id

        }.invalidToken {
            render "Invalid or duplicate form submission"
        }
    }
}

class UserUpdateCommand implements grails.validation.Validateable {

    Long id
    String email
    String username
    String password
    String passwordRepeat

    static constraints = {
        importFrom User, include: ['email, username']

        username(size: 4..50, blank: false, nullable: false,
                validator: { value, urc ->
                    User user = User.findByUsername(urc.username, [max: 1])
                    if (user && user.id != urc.id) {
                        return 'userEdit.username.alreadyExist'
                    }
                }
        )

        email(email: true,
                validator: { value, urc ->
                    User user = User.findByEmail(urc.email, [max: 1])
                    if (user && user.id != urc.id) {
                        return 'userEdit.email.alreadyExist'
                    }

                }
        )

        password(size: 6..50, blank: true, nullable: true,
                validator: { value, urc ->

                    if (urc?.passwordRepeat != value) {
                        return 'userEdit.passwordAndPasswordRepeat.mismatch'
                    }

                    if (value == urc.username) {
                        return 'userEdit.usernameAndPassword.mustNotMatch'
                    }

                    true
                }
        )

        passwordRepeat(blank: true, nullable: true,
                validator: { value, urc ->

                    if (urc?.password != value) {
                        return 'userEdit.passwordAndPasswordRepeat.mismatch'
                    }

                    true
                }
        )
    }


}
