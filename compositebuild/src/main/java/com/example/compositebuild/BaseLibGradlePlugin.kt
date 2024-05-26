package com.example.compositebuild

/**
 *Author: chinadragon
 *Time: 2024/5/21
 */

import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class BaseLibGradlePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.run {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("com.google.devtools.ksp")

            }
            extensions.configure<LibraryExtension> {
                namespace = "com.example.baselib"
                compileSdk = Versions.compileSdk

                defaultConfig {
                    minSdk = Versions.minSdk

                    testInstrumentationRunner = CommonDefaultConfig.testInstrumentationRunner
                    consumerProguardFiles("consumer-rules.pro")
                }
                buildTypes {
                    release {
                        isMinifyEnabled = false
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }
                }
                compileOptions {
                    sourceCompatibility = JavaVersions.sourceCompatibility
                    targetCompatibility = JavaVersions.targetCompatibility
                }
                kotlinOptions {
                    jvmTarget = JavaVersions.jvmTarget
                }
                buildFeatures {
                    dataBinding = true
                }
            }

            dependencies {
                coreLib()
                testLib()
            }
        }
    }
}