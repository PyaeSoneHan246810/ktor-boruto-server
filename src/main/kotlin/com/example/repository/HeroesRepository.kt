package com.example.repository

import com.example.models.Hero
import com.example.models.HeroesResponse

interface HeroesRepository {
    val heroes: List<Hero>
    suspend fun getAllHeroes(page: Int = 1, limit: Int = 3): HeroesResponse
    suspend fun searchHeroes(name: String?): HeroesResponse
}