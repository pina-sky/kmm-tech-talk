package com.kmmtechtalk.feature.spacex

import com.kmmtechtalk.feature.spacex.api.SpaceXApi
import com.kmmtechtalk.feature.spacex.api.SpaceXApiImpl
import com.kmmtechtalk.feature.spacex.repository.SpaceXRepository
import com.kmmtechtalk.feature.spacex.repository.SpaceXRepositoryImpl
import com.kmmtechtalk.feature.spacex.usecase.GetRocketLaunchesUseCase
import com.kmmtechtalk.feature.spacex.usecase.GetRocketLaunchesUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val spaceXModule = module {
    factoryOf(::SpaceXApiImpl) bind SpaceXApi::class
    factoryOf(::SpaceXRepositoryImpl) bind SpaceXRepository::class
    factoryOf(::GetRocketLaunchesUseCaseImpl) bind GetRocketLaunchesUseCase::class
}
