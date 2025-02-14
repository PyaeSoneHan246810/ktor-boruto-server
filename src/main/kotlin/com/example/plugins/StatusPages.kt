package com.example.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*


fun Application.configureStatusPages() {
    install(StatusPages) {
        status(HttpStatusCode.NotFound){ call, httpStatusCode ->
            call.respond(status = httpStatusCode, message = "404: Page Not Found.")
        }
    }
}