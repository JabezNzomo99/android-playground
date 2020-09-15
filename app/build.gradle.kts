plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id("org.jlleitschuh.gradle.ktlint")
    id(BuildPlugins.kapt)
}

android {
    compileSdkVersion(AndroidSdk.compile)
    buildToolsVersion("29.0.3")

    defaultConfig {
        applicationId = "com.jabezmagomere.playground"
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 1
        versionName = "1.0"
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
    }
    // To inline the bytecode built with JVM target 1.8 into
    // bytecode that is being built with JVM target 1.6. (e.g. navArgs)
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    (kotlinOptions as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions).apply {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    dynamicFeatures = mutableSetOf(
        BuildModules.Features.News,
        BuildModules.Features.Weather,
        BuildModules.Features.Entertainment
    )
}

dependencies {
    api("androidx.legacy:legacy-support-v4:1.0.0")
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    api(project(BuildModules.Libraries.Core))
    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.appCompat)
    api(Libraries.ktxCore)

    api(Libraries.material)
    api(Libraries.constraintLayout)
    api(Libraries.vectorDrawable)
    api(Libraries.Navigation.navigationFragment)
    api(Libraries.Navigation.navigationUi)
    api(Libraries.lifecycleExtensions)
    api(Libraries.Navigation.navigationFragmentKtx)
    api(Libraries.Navigation.navigationUiKtx)

    //Coroutines for asynchronous programming
    api(Libraries.Coroutines.coroutinesLibrary)
    api(Libraries.Coroutines.coroutinesAndroidLibrary)
    api(Libraries.Coroutines.liveDataBuilder)
    api(Libraries.Coroutines.lifecycleScope)


    //Room for offline storage
    annotationProcessor(Libraries.Room.roomCompiler)
    api(Libraries.Room.roomKtx)
    api(Libraries.Room.roomRuntime)

    //Dependency Injection using Dagger
    api(Libraries.Dagger.dagger)
    annotationProcessor(Libraries.Dagger.daggerKapt)

    //Networking Libraries
    api(Libraries.Network.gsonConverter)
    api(Libraries.Network.loggingInterceptor)
    api(Libraries.Network.retrofit)
    api(Libraries.Network.okHttp3)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)
}
