package com.kmmtechtalk.feature.spacex.api

import com.kmmtechtalk.feature.spacex.model.RocketLaunch

interface SpaceXApi {
    suspend fun getAllLaunches(): List<RocketLaunch>
}