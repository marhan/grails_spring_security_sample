package grails.spring.security.sample

import grails.plugin.springsecurity.annotation.Secured
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

        def command = new UserUpateCommand('id': user.id, 'username': user.username, 'email': user.email)
        render view: 'edit', model: [user: command]
    }

    def update(UserUpateCommand command) {

        if(command.id == null) {
            redirect action: 'edit'
        }

        User user = User.get(command.id)

        if(!user) {
            throw new Exception("Not user found for id ${command.id}")
        }

        def loggedInUser = springSecurityService.currentUser

        if (loggedInUser.id != user.id) {
            def message = "User ${loggedInUser} has tried to edit ${user}!"
            log.info(message)
            throw new AccessDeniedException(message)
        }

        user.email = command.email
        user.username = command.username

        if(command.password != null && !command.password.isEmpty()) {
            user.password = springSecurityService.encodePassword(command.password)
        }

        user.save()

        if (user.hasErrors()) {
            log.debug("User data ${user} cant't be stored, due to errors!")
            render view: 'edit', model: [user: user]
            return
        }

        log.info("User data ${user} successfully saved")

        redirect action: 'edit', id: user.id

    }

}

class UserUpateCommand {

    Long id
    String email
    String username
    String password
    String passwordRepeat

    static constraints = {
        importFrom User
        password(size: 6..50, blank: false,
                validator: { passwd, urc ->
                    return passwd != urc.username
                })
        passwordRepeat(nullable: false,
                validator: { passwd2, urc ->
                    return passwd2 == urc.password
                })
    }

}
