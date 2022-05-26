package com.kmmtechtalk.feature.spacex.usecase

import com.kmmtechtalk.feature.spacex.model.RocketLaunch
import com.kmmtechtalk.feature.spacex.repository.SpaceXRepository

internal class GetRocketLaunchesUseCaseImpl(
    private val repository: SpaceXRepository
) : GetRocketLaunchesUseCase {
    override suspend fun invoke(): List<RocketLaunch> {
        return repository.getAllLaunches()
    }
}
