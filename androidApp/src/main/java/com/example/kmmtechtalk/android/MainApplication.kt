package com.example.kmmtechtalk.android

import android.app.Application
import com.example.kmmtechtalk.android.rocketLaunches.rocketLaunchesViewModelModule
import com.example.kmmtechtalk.initKoin
import org.koin.android.ext.koin.androidContext

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@MainApplication)
            modules(rocketLaunchesViewModelModule)
        }
    }
}