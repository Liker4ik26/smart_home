import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "com.example.smartHome"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.smartHome"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    val supabaseAnonKey = gradleLocalProperties(rootDir).getProperty("SUPABASE_ANON_KEY")
    val supabaseUrl = gradleLocalProperties(rootDir).getProperty("SUPABASE_URL")
    val secret = gradleLocalProperties(rootDir).getProperty("SECRET")

    buildTypes {
        getByName("debug") {
            buildConfigField(
                "String",
                "SUPABASE_ANON_KEY",
                supabaseAnonKey
            )
            buildConfigField("String", "SECRET", secret)
            buildConfigField("String", "SUPABASE_URL", supabaseUrl)
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField(
                "String",
                "SUPABASE_ANON_KEY",
                supabaseAnonKey
            )
            buildConfigField("String", "SECRET", secret)
            buildConfigField("String", "SUPABASE_URL", supabaseUrl)
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    ksp {
        arg("compose-destinations.generateNavGraphs", "false")
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation("androidx.paging:paging-common-android:3.3.0-alpha02")
    val supabaseVersion = "1.4.7"
    val ktorVersion = "2.3.5"
    val hiltVersion = "2.48"
    val destinations = "1.8.33-beta"
    val moshi = "1.14.0"

    implementation("io.github.raamcosta.compose-destinations:core:$destinations")
    ksp("io.github.raamcosta.compose-destinations:ksp:$destinations")


    implementation("androidx.core:core-splashscreen:1.0.1")

    implementation("com.google.dagger:hilt-android:$hiltVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0-rc01")
    kapt("com.google.dagger:hilt-compiler:$hiltVersion")

    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))

    implementation("io.github.jan-tennert.supabase:postgrest-kt:$supabaseVersion")
    implementation("io.github.jan-tennert.supabase:storage-kt:$supabaseVersion")
    implementation("io.github.jan-tennert.supabase:gotrue-kt:$supabaseVersion")

    implementation("io.ktor:ktor-client-android:$ktorVersion")
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-utils:$ktorVersion")

    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.foundation:foundation-android:1.5.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation("com.google.accompanist:accompanist-systemuicontroller:0.29.1-alpha")

    implementation("com.google.android.gms:play-services-tasks:18.0.2")
    implementation("com.google.android.play:core-ktx:1.8.1")

    implementation("com.squareup.moshi:moshi-adapters:$moshi")
    ksp("com.squareup.moshi:moshi-kotlin-codegen:$moshi")

    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.2")

    implementation("com.google.accompanist:accompanist-swiperefresh:0.23.1")

    implementation("io.coil-kt:coil-compose:2.2.2")

    implementation("com.google.accompanist:accompanist-placeholder-material:0.28.0")
}
