package com.kmmtechtalk.feature.spacex.repository

import com.kmmtechtalk.feature.spacex.api.SpaceXApi
import com.kmmtechtalk.feature.spacex.model.RocketLaunch

internal class SpaceXRepositoryImpl(
    private val api: SpaceXApi
) : SpaceXRepository {

    override suspend fun getAllLaunches(): List<RocketLaunch> {
        return api.getAllLaunches()
    }
}