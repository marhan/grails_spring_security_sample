package grails.spring.security.sample

import grails.plugin.springsecurity.annotation.Secured

class RoleAuthorityController {

    @Secured(['ROLE_ADMIN'])
    def admin() {

    }

    @Secured(['ROLE_USER'])
    def user() {

    }
}
