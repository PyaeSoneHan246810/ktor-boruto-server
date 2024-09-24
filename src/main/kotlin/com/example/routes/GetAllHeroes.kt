package com.example.routes

import com.example.models.HeroesResponse
import com.example.repository.HeroesRepository
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.getAllHeroes() {
    val heroesRepository: HeroesRepository by inject<HeroesRepository>()
    get(path = "/boruto/heroes") {
        try {
            val page = call.queryParameters["page"]?.toInt() ?: 1
            val limit = call.queryParameters["limit"]?.toInt() ?: 3
            require(page > 0 && limit >= 1)
            val heroesResponse = heroesRepository.getAllHeroes(page = page, limit = limit)
            call.respond(
                status = HttpStatusCode.OK,
                message = heroesResponse
            )
        } catch (e: NumberFormatException) {
            call.respond(
                status = HttpStatusCode.BadRequest,
                message = HeroesResponse(
                    success = false,
                    message = "Only numbers allowed."
                )
            )
        } catch (e: IllegalArgumentException) {
            call.respond(
                status = HttpStatusCode.Forbidden,
                message = HeroesResponse(
                    success = false,
                    message = "Heroes not found."
                )
            )
        }
    }
}