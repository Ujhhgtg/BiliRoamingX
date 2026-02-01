@file:Suppress("UnstableApiUsage")

// Source - https://stackoverflow.com/a/60474096
// Posted by i30mb1, modified by community. See post 'Timeline' for change history
// Retrieved 2026-02-01, License - CC BY-SA 4.0
fun getLocalProperty(key: String, file: String = "local.properties"): Any {
    val properties = java.util.Properties()
    val localProperties = File(file)
    if (localProperties.isFile) {
        java.io.InputStreamReader(java.io.FileInputStream(localProperties), Charsets.UTF_8).use { reader ->
            properties.load(reader)
        }
    } else error("File from not found")

    return properties.getProperty(key)
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    val gprUser = getLocalProperty("gpr.user")
    val gprKey = getLocalProperty("gpr.key")
    repositories {
        mavenCentral()
        mavenLocal()
        google()
        maven { url = uri("https://jitpack.io") }
        maven {
            url = uri("https://maven.pkg.github.com/ReVanced/revanced-patcher")
            credentials {
                username = gprUser as String
                password = gprKey as String
            }
        }
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

include(
    ":integrations:app",
    ":integrations:dummy",
    ":integrations:extend",
    ":integrations:ksp",
    ":integrations",
    ":patches"
)
rootProject.name = "BiliRoamingX"
