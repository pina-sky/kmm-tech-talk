package com.example.kmmtechtalk

import com.kmmtechtalk.feature.spacex.spaceXModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

// Aggregator module
private val commonModule = module {
    includes(
        spaceXModule
    )
}

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(commonModule)
}
