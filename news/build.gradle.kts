import java.io.FileInputStream
import java.util.Properties

plugins {
    id(BuildPlugins.dynamicFeaturePlugin)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kapt)
}

val fis = FileInputStream("keys.properties")
val prop = Properties()
prop.load(fis)

android {
    compileSdkVersion(AndroidSdk.compile)
    defaultConfig {
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 1
        versionName = "1.0"
        buildConfigField("String", "GUARDIAN_API_KEY", prop.getProperty("GUARDIAN_API_KEY"))
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(BuildModules.Libraries.App))
}
