plugins {
    id(BuildPlugins.androidLibraryPlugin)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kapt)
}

android {
    compileSdkVersion(AndroidSdk.compile)
    buildToolsVersion("29.0.3")

    defaultConfig {
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    (kotlinOptions).apply {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.appCompat)
    implementation(Libraries.ktxCore)
    implementation(Libraries.Room.roomRuntime)
    implementation(Libraries.Room.roomKtx)
    kapt(Libraries.Room.roomCompiler)

    // Koin
    implementation(Libraries.Koin.koinAndroid)
    implementation(Libraries.Koin.koinExt)
    implementation(Libraries.Koin.koinScope)
    implementation(Libraries.Koin.koinViewModel)

    // Networking Libraries
    implementation(Libraries.Network.gsonConverter)
    implementation(Libraries.Network.loggingInterceptor)
    implementation(Libraries.Network.retrofit)
    implementation(Libraries.Network.okHttp3)

    // Chucker Network Interceptor
    debugImplementation(Libraries.Chucker.debug)
    releaseImplementation(Libraries.Chucker.release)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)
}
