grails.plugin.springsecurity.interceptUrlMap = [
        '/':                    ['permitAll'],
        '/fullAuthenticated/*': ['isFullyAuthenticated()']
]