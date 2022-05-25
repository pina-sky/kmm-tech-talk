package com.kmmtechtalk.feature.spacex.api

import com.kmmtechtalk.core.network.httpClient
import com.kmmtechtalk.feature.spacex.model.RocketLaunch
import io.ktor.client.call.*
import io.ktor.client.request.*

class SpaceXApiImpl : SpaceXApi {
    override suspend fun getAllLaunches(): List<RocketLaunch> {
        return httpClient.get(SPACEX_ENDPOINT).body()
    }

    companion object {
        private const val SPACEX_ENDPOINT = "https://api.spacexdata.com/v3/launches"
    }
}