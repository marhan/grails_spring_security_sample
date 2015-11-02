package grails.spring.security.sample

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.context.SecurityContextHolder

class DevelopmentDataPopulator {

    private static final String ADMIN_NAME = 'admin'
    private static final String ADMIN_PASSWORD = 'password'

    private static final String USER_NAME = 'user'
    private static final String USER_PASSWORD = 'password'

    private static final String ROLE_ADMIN = 'ROLE_ADMIN'
    private static final String ROLE_USER = 'ROLE_USER'

    private admin
    private users

    void populate(ctx) {

        def sessionFactory = ctx.sessionFactory

        createUsers()
        loginAsAdmin()
        sessionFactory.currentSession.flush()
    }

    private void loginAsAdmin() {

        // have to be authenticated as an admin to create ACLs
        SecurityContextHolder.context.authentication = new UsernamePasswordAuthenticationToken(
                ADMIN_NAME,
                ADMIN_PASSWORD,
                AuthorityUtils.createAuthorityList(ROLE_ADMIN))

    }

    private void createUsers() {

        def adminCreator = new UserDataCreator(
                baseUsername: ADMIN_NAME,
                basePassword: ADMIN_PASSWORD,
                authorities: [ROLE_ADMIN])

        admin = adminCreator.populate()[0]

        def usersCreator = new UserDataCreator(
                baseUsername: USER_NAME,
                basePassword: USER_PASSWORD,
                quantity: 3,
                authorities: [ROLE_USER])

        users = usersCreator.populate()

    }

}
