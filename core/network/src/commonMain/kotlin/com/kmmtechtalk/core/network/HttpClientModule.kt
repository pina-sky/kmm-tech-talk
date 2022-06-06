package com.kmmtechtalk.core.network

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val httpClientModule = module {
    factoryOf<HttpClient> {
        HttpClient {
            install(ContentNegotiation) {
                val jsonConfigs = Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                }
                json(jsonConfigs)
            }
        }
    }
}