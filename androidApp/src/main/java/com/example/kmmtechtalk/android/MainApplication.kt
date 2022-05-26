package com.example.kmmtechtalk.android

import android.app.Application
import com.example.kmmtechtalk.getKoinSharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(
                getKoinSharedModule(),
                mainViewModelModule
            )
        }
    }
}