plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
    id ("kotlin-parcelize")
}

android {
    namespace = "com.farwah.daggerhiltexample"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.farwah.daggerhiltexample"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
       }
    }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
        kotlinOptions {
            jvmTarget = "1.8"
        }
    buildFeatures {
        viewBinding = true
    }
}

  dependencies {

      implementation(libs.androidx.core.ktx)
      implementation(libs.material)
      implementation(libs.androidx.appcompat)
      implementation(libs.androidx.constraintlayout)
      implementation(libs.androidx.navigation.fragment.ktx)
      implementation(libs.androidx.navigation.ui.ktx)
      testImplementation(libs.junit)
      androidTestImplementation(libs.androidx.junit)
      androidTestImplementation(libs.androidx.espresso.core)



      //Dagger - Hilt
      implementation ("com.google.dagger:hilt-android:2.51.1")
      kapt ("com.google.dagger:hilt-android-compiler:2.51.1")
      kapt ("androidx.hilt:hilt-compiler:1.0.0-alpha03")
      //Coroutines



      // Coroutines
      implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
      implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0")

      // Coroutine Lifecycle Scopes
      implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
      implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")


      // Retrofit & OkHttp
      implementation ("com.squareup.retrofit2:retrofit:2.11.0")
      implementation ("com.squareup.retrofit2:converter-gson:2.11.0")
      implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.14")

      // Glide to load imageurl
      implementation ("com.github.bumptech.glide:glide:4.16.0")
      kapt ("com.github.bumptech.glide:compiler:4.16.0")


      // this library help me to provide view model

  }

kapt {
    correctErrorTypes =true
}