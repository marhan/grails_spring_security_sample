// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.rememberMe.cookieName = "grails_spring_security_example_cookie"
grails.plugin.springsecurity.rememberMe.tokenValiditySeconds = 60 * 60 * 24 * 2
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/', access: ['permitAll']],
        [pattern: '/index', access: ['permitAll']],
        [pattern: '/index.gsp', access: ['permitAll']],
        [pattern: '/assets/**', access: ['permitAll']],
        [pattern: '/**/js/**', access: ['permitAll']],
        [pattern: '/**/css/**', access: ['permitAll']],
        [pattern: '/**/images/**', access: ['permitAll']],
        [pattern: '/**/plugins/**', access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']],
        [pattern: '/register/**', access: ['permitAll']],
        [pattern: '/login/**', access: ['permitAll']],
        [pattern: '/logout/**', access: ['permitAll']],
        [pattern: '/dbconsole/**', access: ['permitAll']],
        [pattern: '/**', access: ['permitAll']]
]

grails.plugin.springsecurity.apf.storeLastUsername = true

grails.plugin.springsecurity.userLookup.userDomainClassName = 'grails.spring.security.sample.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'grails.spring.security.sample.UserRole'
grails.plugin.springsecurity.authority.className = 'grails.spring.security.sample.Role'
grails.plugin.springsecurity.logout.postOnly = false

grails.plugin.springsecurity.rememberMe.cookieName = "grails_spring_security_sample_cookie"
grails.plugin.springsecurity.rememberMe.tokenValiditySeconds = 60 * 60 * 24 * 2

grails.plugin.springsecurity.rememberMe.persistent = true
grails.plugin.springsecurity.rememberMe.persistentToken.domainClassName = 'grails.spring.security.sample.PersistentLogin'

