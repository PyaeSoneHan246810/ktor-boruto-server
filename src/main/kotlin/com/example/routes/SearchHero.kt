package com.example.routes

import com.example.repository.HeroesRepository
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.searchHeroes() {
    val heroesRepository: HeroesRepository by inject<HeroesRepository>()
    get(path = "/boruto/heroes/search") {
        val name = call.request.queryParameters["name"]
        val heroesResponse = heroesRepository.searchHeroes(name)
        call.respond(
            status = HttpStatusCode.OK,
            message = heroesResponse
        )
    }
}