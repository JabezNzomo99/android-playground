const val kotlinVersion = "1.3.72"

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "3.6.2"
        const val ktlintPlugin = "9.2.1"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kapt = "kotlin-kapt"
    const val androidLibraryPlugin = "com.android.library"
    const val dynamicFeaturePlugin = "com.android.dynamic-feature"

}

object AndroidSdk {
    const val min = 15
    const val compile = 29
    const val target = compile
}

object Libraries {
    private object Versions {
        const val jetpack = "1.1.0"
        const val constraintLayout = "1.1.3"
        const val ktxCore = "1.3.1"
        const val material = "1.1.0"
        const val navigation = "2.3.0"
        const val lifecycle = "2.2.0"
        const val coroutines = "1.3.9"
        const val room = "2.2.5"
        const val retrofit = "2.8.1"
        const val interceptor = "4.5.0"
        const val okHttp = "4.5.0"
        const val dagger = "2.27"
        const val ktxCoroutines = "2.2.0-alpha01"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.jetpack}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktxCore}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val vectorDrawable = "androidx.vectordrawable:vectordrawable:${Versions.jetpack}"

    object Coroutines {
        const val coroutinesLibrary =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val coroutinesAndroidLibrary =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val liveDataBuilder =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.ktxCoroutines}"
        const val lifecycleScope =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.ktxCoroutines}"
    }

    object Room {
        const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
        const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
        const val roomTesting = "androidx.room:room-testing:${Versions.room}"
    }

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
        const val loggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"
        const val okHttp3 = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    }

    object Dagger {
        const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
        const val daggerKapt = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    }

    object Navigation {
        const val navigationUi = "androidx.navigation:navigation-ui:${Versions.navigation}"
        const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
        const val navigationFragment =
            "androidx.navigation:navigation-fragment:${Versions.navigation}"
        const val dynamicNavigation =
            "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"
        const val navigationFragmentKtx =
            "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    }

}

object TestLibraries {
    private object Versions {
        const val junit4 = "4.12"
        const val testRunner = "1.1.1"
        const val espresso = "3.2.0"
    }

    const val junit4 = "junit:junit:${Versions.junit4}"
    const val testRunner = "androidx.test.ext:junit:${Versions.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

object BuildModules {
    object Features {
        const val Entertainment = ":entertainment"
        const val News = ":news"
        const val Weather = ":weather"
    }

    object Libraries {
        const val Core = ":core"
        const val App = ":app"
    }
}