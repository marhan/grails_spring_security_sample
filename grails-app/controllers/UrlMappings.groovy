import org.springframework.security.access.AccessDeniedException

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "404"(view:'/notFound')
        "403"(controller: "errors", action: "error403")
        "500"(controller: "errors", action: "error500")
        "500"(controller: "errors", action: "error403", exception: AccessDeniedException)
    }
}
