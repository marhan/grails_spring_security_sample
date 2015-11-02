package grails.spring.security.sample

import grails.plugin.springsecurity.annotation.Secured

@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
class AnonymousAuthenticatedController {

    def index() {}
}
