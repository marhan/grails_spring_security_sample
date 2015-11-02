package grails.spring.security.sample

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.context.SecurityContextHolder

class DevelopmentDataPopulator {

    private static final String ADMIN_USERNAME = 'admin'
    private static final String ADMIN_PASSWORD = 'admin123'

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
                ADMIN_USERNAME,
                ADMIN_PASSWORD,
                AuthorityUtils.createAuthorityList(ROLE_ADMIN))

    }

    private void createUsers() {

        def adminCreator = new UserDataCreator(
                baseUsername: ADMIN_USERNAME,
                basePassword: ADMIN_PASSWORD,
                authorities: [ROLE_ADMIN, ROLE_USER])

        admin = adminCreator.populate()[0]

        def usersCreator = new UserDataCreator(
                baseUsername: 'user',
                basePassword: 'password',
                quantity: 3,
                authorities: [ROLE_USER])

        users = usersCreator.populate()

    }

}
