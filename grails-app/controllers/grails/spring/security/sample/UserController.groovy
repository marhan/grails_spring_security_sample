package grails.spring.security.sample

class UserController {

    def edit() {

        User user = User.get(params.id)

        if (request.method == 'GET') {
            render view: 'edit', model: [user: user]
            return
        }

        user.email = params.email
        user.username = params.username
        user.password = params.password

        user.save(flush: true)

        if (user.hasErrors()) {
            render edit: 'edit', model: [user: user]
            return
        }

        render view: 'edit', model: [user: user]

    }
}
