package grails.spring.security.sample

class UserDataCreator {

    String baseUsername
    String basePassword
    Long quantity = 1
    def authorities = []
    def users = []

    def populate() {

        assert baseUsername
        assert basePassword
        assert quantity
        assert authorities

        quantity.times {

            def number = it + 1
            def username = quantity > 1 ? "$baseUsername$number" : baseUsername
            def password = quantity > 1 ? "$basePassword$number" : basePassword

            def user = new User(
                    username: username,
                    enabled: true,
                    password: password,
                    email: "$username@security.com")

            user.save(flush: true, failOnError: true)

            authorities.each {

                def role = Role.findByAuthority(it)

                if (!role){
                    role = new Role(authority: it).save(flush: true, failOnError: true)
                }

                UserRole.create user, role, true
            }

            users << user
        }

       users
    }

}
