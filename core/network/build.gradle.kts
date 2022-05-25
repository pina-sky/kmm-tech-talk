plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

kotlin {
    android()
    ios()

    sourceSets {
        // Common
        val commonMain by getting {
            dependencies {
                api(libs.ktor)
                implementation(libs.ktor.serialization)
                implementation(libs.ktor.contentnegotiation)
            }
        }

        // Android
        val androidMain by getting {
            dependencies {
                implementation(libs.ktor.client.android)
            }
        }

        // iOS
        val iosMain by getting {
            dependencies {
                implementation(libs.ktor.client.ios)
            }
        }
    }
}

android {
    compileSdk = libs.versions.androidsdk.compile.get().toInt()
    namespace = "com.kmmtechtalk.core.network"
    defaultConfig {
        minSdk = libs.versions.androidsdk.min.get().toInt()
        targetSdk = libs.versions.androidsdk.target.get().toInt()
    }
}