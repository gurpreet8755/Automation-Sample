import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}



val keystoreProps = Properties()
val localPropsFile = rootProject.file("local.properties")

if (localPropsFile.exists()) {
    localPropsFile.inputStream().use {
        keystoreProps.load(it)
    }
}

android {
    namespace = "com.nk.demogithubautomation"
    compileSdk = 35

    lint {
        checkReleaseBuilds = false
        abortOnError = false
        disable.add("all")
        disable.add("DeprecatedLintCheck") // Use the specific rule ID
    }

    defaultConfig {
        applicationId = "com.nk.demogithubautomation"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }



//    signingConfigs {
//        create("release") {
//            storeFile = file("/Users/rockysingh/drives/Professiosnal/G-Work/Projects/DemoGithubautomation/app/automation-keystore.jks")
//            storePassword = "Github@0055"
//            keyAlias = "Automation-github"
//            keyPassword = "Github@0055"
//        }
//    }

    signingConfigs {
        create("release") {
            storeFile = file(keystoreProps["KEYSTORE_FILE_BASE64"] as? String
                ?: System.getenv("KEYSTORE_FILE_BASE64"))
            storePassword = keystoreProps["KEYSTORE_PASSWORD"] as? String
                ?: System.getenv("KEYSTORE_PASSWORD")
            keyAlias = keystoreProps["KEY_ALIAS"] as? String
                ?: System.getenv("KEY_ALIAS")
            keyPassword = keystoreProps["KEY_PASSWORD"] as? String
                ?: System.getenv("KEY_PASSWORD")
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isShrinkResources = false
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

//    buildTypes {
////        getByName("release") {
////            signingConfig = signingConfigs.getByName("release")
////        }
//        release {
//            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
//    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

