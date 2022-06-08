import org.jetbrains.kotlin.gradle.plugin.mpp.Framework
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("com.android.library")
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