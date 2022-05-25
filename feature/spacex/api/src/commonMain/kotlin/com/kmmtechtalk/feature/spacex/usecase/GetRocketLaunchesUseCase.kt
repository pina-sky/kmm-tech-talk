package com.kmmtechtalk.feature.spacex.usecase

import com.kmmtechtalk.feature.spacex.model.RocketLaunch

interface GetRocketLaunchesUseCase {
    suspend operator fun invoke(): List<RocketLaunch>
}