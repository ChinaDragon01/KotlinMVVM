plugins {

    `kotlin-dsl`
}

gradlePlugin {

    plugins {
        register("AppGradlePlugin") {
            id = "app.gradle.plugin"
            implementationClass = "com.example.compositebuild.AppGradlePlugin"
        }

        register("BaseLibGradlePlugin") {
            id = "baselib.gradle.plugin"
            implementationClass = "com.example.compositebuild.BaseLibGradlePlugin"
        }
    }
}

dependencies {
    implementation("com.android.tools.build:gradle:8.1.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
}