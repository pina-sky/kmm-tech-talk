package com.kmmtechtalk.feature.spacex

import com.kmmtechtalk.feature.spacex.usecase.GetRocketLaunchesUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetRocketLaunchesUseCaseFactory : KoinComponent {

    private val getRocketLaunchesUseCase: GetRocketLaunchesUseCase by inject()

    fun buildGetRocketLaunchesUseCase(): GetRocketLaunchesUseCase {
        return getRocketLaunchesUseCase
    }
}