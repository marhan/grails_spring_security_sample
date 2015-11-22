package grails.spring.security.sample

import grails.plugin.springsecurity.annotation.Secured
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Secured(['permitAll'])
class ErrorsController {

    Logger log = LoggerFactory.getLogger(ErrorsController.class);

    def error403() {
        ErrorDetails errorDetails = buildErrorDetail()
        log.info("${errorDetails} has tried to access restricted content!");

        [errorDetails: errorDetails]
    }

    private buildErrorDetail() {
        def errorType = exception().getClass().name
        def errorMessage = exception().target.message
        new ErrorDetails(type: errorType, message: errorMessage)
    }

    private exception() {
        request.exception.cause ?: request.exception
    }

    def error500() {
        render view: '/error'
    }
}

class ErrorDetails {
    String type
    String message
}
