import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    kotlin("android")
    jacoco
    //despite doc found here : https://docs.gradle.org/current/userguide/jacoco_plugin.html
    // this does not generate any "jacocoTestReport" task.
    // I read in multiple places that on Android Studio one should look for createDebugCoverageReport, but it's not here either
}

android {
    compileSdk = ConfigData.compileSdkVersion
    buildToolsVersion = ConfigData.buildToolsVersion
    namespace = "com.jacocoexp"

    defaultConfig {
        applicationId = "com.jacocoexp"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            applicationIdSuffix = ".debug"
            isDebuggable = true
            enableUnitTestCoverage = true // this is needed for jacoco to be able to generate coverage report
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}

dependencies {
    implementation(Deps.kotlin)
    implementation(Deps.appCompat)
    implementation(Deps.materialDesign)
    implementation(Deps.constraintLayout)
    testImplementation(Deps.jupiter)
}

tasks {

    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    withType<Test> {
        useJUnitPlatform() //we want tests to run with junit5
    }

    withType<JacocoReport> {
        // to trigger tests task before the coverage report generation, and ensure fresh results:
        dependsOn("testDebugUnitTest")
        //setting option for jacoco report to be generated as html
        reports {
            xml.required.set(true)
            csv.required.set(true)
            html.required.set(true)
        }
    }
}

jacoco{
    toolVersion = "0.8.8"
    // to move the generated report somewhere else set:
    //html.outputLocation.set(layout.buildDirectory.dir("jacoco"))
}