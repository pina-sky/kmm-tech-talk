plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
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

    sourceSets {
        // Common
        val commonMain by getting {
            dependencies {
                implementation(libs.coroutines)
                implementation(libs.serialization)
                implementation(libs.ktor)
                implementation(libs.ktor.serialization)
                implementation(libs.sqldelight.runtime)
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
                implementation(libs.ktor.client.android)
                implementation(libs.sqldelight.driver.android)
            }
        }
        val androidTest by getting

        // iOS
        val iosMain by getting {
            dependencies {
                implementation(libs.ktor.client.ios)
                implementation(libs.sqldelight.driver.ios)
            }
        }
        val iosTest by getting
    }
}

android {
    compileSdk = libs.versions.androidsdk.compile.get().toInt()
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = libs.versions.androidsdk.min.get().toInt()
        targetSdk = libs.versions.androidsdk.target.get().toInt()
    }
}