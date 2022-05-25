package com.kmmtechtalk.feature.spacex.usecase

import com.kmmtechtalk.feature.spacex.model.RocketLaunch
import com.kmmtechtalk.feature.spacex.repository.SpaceXRepository

class GetRocketLaunchesUseCaseImpl(
    private val repository: SpaceXRepository// TODO this should be injected
) : GetRocketLaunchesUseCase {
    override suspend fun invoke(): List<RocketLaunch> {
        return repository.getAllLaunches()
    }
}
