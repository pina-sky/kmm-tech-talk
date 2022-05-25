package com.kmmtechtalk.core.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

// TODO this should be provided through DI
val httpClient = HttpClient {
    install(ContentNegotiation) {
        val jsonConfigs = Json {
            ignoreUnknownKeys = true
            prettyPrint = true
        }
        json(jsonConfigs)
    }
}