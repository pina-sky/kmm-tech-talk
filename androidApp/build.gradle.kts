plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = libs.versions.androidsdk.compile.get().toInt()
    defaultConfig {
        applicationId = "com.example.kmmtechtalk.android"
        minSdk = libs.versions.androidsdk.min.get().toInt()
        targetSdk = libs.versions.androidsdk.target.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(projects.shared)
    implementation(projects.feature.spacex.api)
    implementation(projects.feature.spacex.impl)

    implementation(libs.androidx.activity)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.common)
    implementation(libs.androidx.lifecycle.livedata)
    implementation(libs.androidx.lifecycle.viewmodel)

    implementation(libs.koin)
    implementation(libs.koin.android)

    implementation(libs.material)
}
