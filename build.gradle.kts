// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    extra.apply{
        set("kotlinVersion", "1.7.20")
    }
    val supportLibraryVersion = extra.get("kotlinVersion") as String

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:7.4.0")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:$supportLibraryVersion")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

plugins {
// see files coverage.gradle.kts and CoveragePluginDSL.kts in buildSrc folder
// article : https://medium.com/@gmazzo65/generating-android-jvm-aggregated-coverage-reports-53e912b2e63c
//  source : https://github.com/gmazzo/android-jacoco-aggregated-demo
  coverage
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}