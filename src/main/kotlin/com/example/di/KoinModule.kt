package com.example.di

import com.example.repository.HeroesRepository
import com.example.repository.HeroesRepositoryImpl
import org.koin.dsl.module

val koinModule = module {
    single<HeroesRepository> {
        HeroesRepositoryImpl()
    }
}