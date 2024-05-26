package com.example.compositebuild

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

fun DependencyHandlerScope.coreLib(){

    "api"(Libs.core_ktx)
    "api"(Libs.appcompat)
    "api"(Libs.appcompat_resources)
    "api"(Libs.material)
    "api"(Libs.constraintlayout)
    "api"(Libs.activity_ktx)
    "api"(Libs.fragment_ktx)
    "api"(Libs.kotlinx_coroutines_core)
    "api"(Libs.lifecycle_runtime_ktx)
    "api"(Libs.lifecycle_livedata_ktx)
    "api"(Libs.lifecycle_viewmodel_ktx)
    "api"(Libs.work_runtime_ktx)
    "api"(Libs.gson)
    "api"(Libs.permissionx)
    "api"(Libs.logger)
    "api"(Libs.swiperefreshlayout)
    "api"(Libs.retrofit)
    "api"(Libs.converterGson)
    "api"(Libs.adapter_rxjava3)
    "api"(Libs.rxjava)
    "api"(Libs.rxandroid)
    "api"(Libs.logging_interceptor)
    "api"(Libs.glide)
    "ksp"(Libs.glide_compiler)
    "api"(Libs.live_event_bus)

    "api"(Libs.room_ktx)
    "api"(Libs.room_runtime)
    "ksp"(Libs.room_compiler)
}

fun DependencyHandlerScope.testLib(){
    "testImplementation"(Libs.junit)
    "androidTestImplementation"(Libs.testjunit)
    "androidTestImplementation"(Libs.espresso)
}


fun CommonExtension<*, *, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)
}