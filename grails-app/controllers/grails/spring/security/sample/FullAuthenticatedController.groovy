package grails.spring.security.sample

import grails.plugin.springsecurity.annotation.Secured

@Secured(['IS_AUTHENTICATED_FULLY'])
class FullAuthenticatedController {

    def index() {}
}
