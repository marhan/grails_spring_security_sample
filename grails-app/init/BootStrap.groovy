import grails.spring.security.sample.DevelopmentDataPopulator

class BootStrap {

    def grailsApplication

    def init = { servletContext ->
        new DevelopmentDataPopulator().populate grailsApplication.mainContext
    }
    def destroy = {
    }
}
