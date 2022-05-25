package com.kmmtechtalk.feature.spacex.repository

import com.kmmtechtalk.feature.spacex.model.RocketLaunch

interface SpaceXRepository {
    suspend fun getAllLaunches(): List<RocketLaunch>
}