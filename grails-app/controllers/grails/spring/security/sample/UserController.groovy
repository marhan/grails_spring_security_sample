package grails.spring.security.sample

import grails.plugin.springsecurity.annotation.Secured
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.core.Authentication

@Secured(['IS_AUTHENTICATED_FULLY'])
class UserController {

    Logger log = LoggerFactory.getLogger(UserController.class);

    def springSecurityService

    def edit() {

        User user = User.get(params.id)


        def loggedInUser = springSecurityService.currentUser

        if(loggedInUser.id != user.id) {

            log.info("User ${loggedInUser} has tried to edit ${user}!")

            throw new AccessDeniedException("Access is denied. You are not allowed to edit user with id ${params.id}")

        }

        if (request.method == 'GET') {
            log.debug("User ${user} is going to be edit his uder data!")
            render view: 'edit', model: [user: user]
            return
        }

        user.email = params.email
        user.username = params.username
        user.password = params.password

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
