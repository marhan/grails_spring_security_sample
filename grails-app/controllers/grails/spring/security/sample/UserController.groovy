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

        user.save()

        if (user.hasErrors()) {
            render view: 'edit', model: [user: user]
            return
        }

        redirect action: 'edit', id: user.id

    }
}
