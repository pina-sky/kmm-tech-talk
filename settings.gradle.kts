pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "kmm-tech-talk"
include(":androidApp")
include(":shared")
include(":feature:spacex:api")
include(":feature:spacex:impl")
