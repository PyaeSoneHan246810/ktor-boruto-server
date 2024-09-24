package com.example.routes

import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.root() {
    get(path = "/") {
        call.respond(
            status = HttpStatusCode.OK,
            message = "Welcome to Boruto API!",
        )
    }
}