package grails.spring.security.sample.sample

import grails.plugin.springsecurity.annotation.Secured;

@Secured(['IS_AUTHENTICATED_REMEMBERED'])
class RememberedAuthenticatedController {

    def index() { }
}
