pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        kotlin("multiplatform") version "1.9.24"
        kotlin("plugin.serialization") version "1.9.24"
        id("com.android.application") version "8.5.2"
        id("org.jetbrains.compose") version "1.6.11"
        id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "NewsReader"
include(":composeApp")