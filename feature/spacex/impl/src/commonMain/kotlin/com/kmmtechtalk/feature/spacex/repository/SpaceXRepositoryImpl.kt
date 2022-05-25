package com.kmmtechtalk.feature.spacex.repository

import com.kmmtechtalk.feature.spacex.api.SpaceXApi
import com.kmmtechtalk.feature.spacex.model.RocketLaunch

class SpaceXRepositoryImpl(
    private val api: SpaceXApi // TODO this should be injected in the constructor
) : SpaceXRepository {

    override suspend fun getAllLaunches(): List<RocketLaunch> {
        return api.getAllLaunches()
    }
}