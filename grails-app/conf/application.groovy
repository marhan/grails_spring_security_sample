
// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.rememberMe.cookieName = "grails_spring_security_example_cookie"
grails.plugin.springsecurity.rememberMe.tokenValiditySeconds = 60 * 60 * 24 * 2
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        '/':                              ['permitAll'],
        '/index':                         ['permitAll'],
        '/index.gsp':                     ['permitAll'],
        '/assets/**':                     ['permitAll'],
        '/**/js/**':                      ['permitAll'],
        '/**/css/**':                     ['permitAll'],
        '/**/images/**':                  ['permitAll'],
        '/**/plugins/**':                 ['permitAll'],
        '/**/favicon.ico':                ['permitAll'],
        '/register/**':                   ['permitAll'],
        '/login/**': 					  ['permitAll'],
        '/logout/**': 					  ['permitAll'],
        '/dbconsole/**':				  ['permitAll'],
        '/user/**':						  ['ROLE_ADMIN'],
        '/role/**':						  ['ROLE_ADMIN'],
        '/registrationCode/**':			  ['ROLE_ADMIN'],
        '/securityInfo/**':			  	  ['ROLE_ADMIN'],
        '/**': 							  ['permitAll']
]

grails.plugin.springsecurity.apf.storeLastUsername = true

grails.plugin.springsecurity.userLookup.userDomainClassName = 'grails.spring.security.sample.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'grails.spring.security.sample.UserRole'
grails.plugin.springsecurity.authority.className = 'grails.spring.security.sample.Role'
grails.plugin.springsecurity.logout.postOnly = false

grails.plugin.springsecurity.rememberMe.cookieName = "grails_spring_security_example_cookie"
grails.plugin.springsecurity.rememberMe.tokenValiditySeconds = 60 * 60 * 24 * 2
