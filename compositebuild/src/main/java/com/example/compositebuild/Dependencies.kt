package com.example.compositebuild

import org.gradle.api.JavaVersion

object CommonDefaultConfig {
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object JavaVersions {
    val sourceCompatibility = JavaVersion.VERSION_17
    val targetCompatibility = JavaVersion.VERSION_17
    val jvmTarget = JavaVersion.VERSION_17.toString()
}

object Versions {

    const val compileSdk = 34
    const val minSdk = 23
    const val targetSdk = 34
    const val versionCode = 1
    const val versionName = "1.0.0"

    const val junit = "4.13.2"
    const val testjunit = "1.1.5"
    const val espresso_core = "3.5.1"

    const val core_ktx = "1.10.1"
    const val activity_ktx = "1.7.2"
    const val fragment_ktx = "1.6.2"
    const val appcompat = "1.6.1"
    const val material = "1.11.0"
    const val workVersion = "2.8.1"
    const val room_version = "2.6.1"
    const val lifecycleVersion = "2.8.0"
    const val constraintlayout = "2.1.4"
    const val swiperefreshlayout = "1.1.0"

    const val gson = "2.10.1"
    const val logger = "2.2.0"
    const val retrofit = "2.11.0"
    const val permissionx = "1.7.1"
    const val glideVersion = "4.16.0"

}

object Libs {

    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val appcompat_resources = "androidx.appcompat:appcompat-resources:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val junit = "junit:junit:${Versions.junit}"
    const val testjunit = "androidx.test.ext:junit:${Versions.testjunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso_core}"

    const val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    const val activity_ktx = "androidx.activity:activity-ktx:${Versions.activity_ktx}"
    const val fragment_ktx = "androidx.fragment:fragment-ktx:${Versions.fragment_ktx}"
    const val kotlinx_coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1"//https://github.com/hltj/kotlinx.coroutines-cn/blob/master/README.md#using-in-your-projects

    const val lifecycle_livedata_ktx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}" //https://developer.android.com/kotlin/ktx?hl=zh-cn
    const val lifecycle_runtime_ktx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
    const val lifecycle_viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"// https://developer.android.google.cn/jetpack/androidx/releases/lifecycle


    const val work_runtime_ktx = "androidx.work:work-runtime-ktx:${Versions.workVersion}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"//https://github.com/google/gson
    const val rxjava = "io.reactivex.rxjava3:rxjava:3.1.3"
    const val rxandroid = "io.reactivex.rxjava3:rxandroid:3.0.0"
    const val logger = "com.orhanobut:logger:${Versions.logger}"
    const val swiperefreshlayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swiperefreshlayout}"//https://developer.android.com/jetpack/androidx/releases/swiperefreshlayout?hl=zh-cn
    const val room_ktx = "androidx.room:room-ktx:${Versions.room_version}"//https://developer.android.com/training/data-storage/room?hl=zh-cn#kts     https://developer.android.com/kotlin/ktx?hl=zh-cn
    const val room_runtime = "androidx.room:room-runtime:${Versions.room_version}"
    const val room_compiler = "androidx.room:room-compiler:${Versions.room_version}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val adapter_rxjava3 = "com.squareup.retrofit2:adapter-rxjava3:${Versions.retrofit}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val logging_interceptor = "com.squareup.okhttp3:logging-interceptor:4.12.0"// https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor
    const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"// https://github.com/bumptech/glide
    const val glide_compiler = "com.github.bumptech.glide:ksp:${Versions.glideVersion}"
    const val live_event_bus = "io.github.jeremyliao:live-event-bus-x:1.8.0"//https://github.com/JeremyLiao/LiveEventBus
    const val permissionx = "com.guolindev.permissionx:permissionx:${Versions.permissionx}"// https://github.com/guolindev/PermissionX

}