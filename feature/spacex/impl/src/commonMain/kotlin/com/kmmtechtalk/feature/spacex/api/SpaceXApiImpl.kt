package com.kmmtechtalk.feature.spacex.api

import com.kmmtechtalk.feature.spacex.model.RocketLaunch
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

internal class SpaceXApiImpl(
    private val httpClient: HttpClient
) : SpaceXApi {
    override suspend fun getAllLaunches(): List<RocketLaunch> {
        return httpClient.get(SPACEX_ENDPOINT).body()
    }

    companion object {
        private const val SPACEX_ENDPOINT = "https://api.spacexdata.com/v3/launches"
    }
}