plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
}

kotlin {
    android()
    ios()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.coroutines)
                implementation(libs.serialization)
            }
        }
    }
}

android {
    compileSdk = libs.versions.androidsdk.compile.get().toInt()
    namespace = "com.kmmtechtalk.feature.spacex.api"
    defaultConfig {
        minSdk = libs.versions.androidsdk.min.get().toInt()
        targetSdk = libs.versions.androidsdk.target.get().toInt()
    }
}