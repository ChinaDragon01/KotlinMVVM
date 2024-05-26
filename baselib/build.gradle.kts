plugins {
    id("baselib.gradle.plugin")
    id("kotlin-kapt")
}

android {
    kapt {
        generateStubs = true
    }

//
//    buildTypes {
//        release {
//            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
//    }
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_1_8
//        targetCompatibility = JavaVersion.VERSION_1_8
//    }
//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
//
//    buildFeatures{
//        viewBinding = true
//    }
}

//dependencies {
//
//}