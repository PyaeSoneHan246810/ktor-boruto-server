package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Hero(
    val id: Int,
    val name: String,
    val image: String,
    val about: String,
    val rating: Double,
    val power: Int,
    val day: String,
    val month: String,
    val family: List<String>,
    val abilities: List<String>,
    val natureTypes: List<String>
)