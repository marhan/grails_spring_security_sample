package grails.spring.security.sample

import org.springframework.security.core.context.SecurityContextHolder

class SecurityTagLib {
    static namespace = "security"

    def name = { attrs ->
        out << SecurityContextHolder.context.authentication?.name
    }

    def ifLoggedIn = {attrs, body ->
        if(SecurityContextHolder.context.authentication?.isAuthenticated()) {
            out << body()
        }
    }
}
