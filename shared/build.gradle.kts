import org.jetbrains.kotlin.gradle.plugin.mpp.Framework
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.squareup.sqldelight")
}

kotlin {
    android()
    ios {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }

    targets.withType<KotlinNativeTarget> {
        binaries.withType<Framework> {
            isStatic = false
            export(projects.feature.spacex.api)

            transitiveExport = true
        }
    }

    sourceSets {
        // Common
        val commonMain by getting {
            dependencies {
                implementation(libs.coroutines)
                implementation(libs.sqldelight.runtime)
                implementation(libs.koin)
                api(projects.feature.spacex.api)
                implementation(projects.feature.spacex.impl)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        // Android
        val androidMain by getting {
            dependencies {
                implementation(libs.sqldelight.driver.android)
            }
        }
        val androidTest by getting

        // iOS
        val iosMain by getting {
            dependencies {
                implementation(libs.sqldelight.driver.ios)
            }
        }
        val iosTest by getting
    }
}

android {
    compileSdk = libs.versions.androidsdk.compile.get().toInt()
    namespace = "com.example.kmmtechtalk"
    defaultConfig {
        minSdk = libs.versions.androidsdk.min.get().toInt()
        targetSdk = libs.versions.androidsdk.target.get().toInt()
    }
}