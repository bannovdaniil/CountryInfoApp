package com.project.first

data class Country(
    val name: CountryName,
    val currencies: Map<String, Currency>,
    val capital: List<String>,
    val flags: Flag,
    val population: Long,
    val area: Double,
    val languages: Map<String, String>,
)

data class CountryName(
    val common: String,
    val official: String,
)

data class Flag(
    val png: String,
)

data class Currency(
    val name: String,
    val symbol: String,
)
