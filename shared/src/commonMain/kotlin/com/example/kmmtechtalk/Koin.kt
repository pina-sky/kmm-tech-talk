package com.example.kmmtechtalk

import com.kmmtechtalk.feature.spacex.spaceXModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

// Aggregator module
val koinModule = module {
    includes(
        spaceXModule
    )
}

// Function to be called in Android app
fun getKoinSharedModule(): Module {
    return koinModule
}

// Function to be called on iOS app to deal with kotlin specifics
fun initKoin() {
    startKoin {
        modules(
            getKoinSharedModule()
        )
    }
}