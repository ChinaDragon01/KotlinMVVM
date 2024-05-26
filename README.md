### 一、简介Android MVVM架构模式

### MVVM架构模式

> MVVM全称：Model、View、ViewModel；
>- Model：负责数据的请求、解析、过滤等数据层操作，其中Repository: 提供数据的 API（从本地或者网络）。
>- View：负责视图部分展示
>- ViewModel：作为View和Model之间的桥梁，负责监听Model的数据变化，并通知View进行更新

### 本demo演示MVVM架构的使用

> - ViewModel
    > [ViewModel overview](https://developer.android.com/topic/libraries/architecture/viewmodel?hl=en)
    > [ViewModel](https://developer.android.com/reference/androidx/lifecycle/ViewModel)
>- [androidx.lifecycle](https://developer.android.google.cn/jetpack/androidx/releases/lifecycle?hl=zh-cn#kts)
>- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata?hl=en)
>- [Databinding](https://developer.android.google.cn/jetpack/androidx/releases/databinding?hl=en)
   > [android.databinding](https://developer.android.com/reference/android/databinding/package-summary?hl=en)
   > [ViewDataBinding](https://developer.android.com/reference/android/databinding/ViewDataBinding?hl=en)
   > [kapt compiler plugin](https://kotlinlang.org/docs/kapt.html)
   > [数据绑定库](https://developer.android.com/topic/libraries/data-binding?hl=zh-cn)
   > [androidx.databinding](https://developer.android.google.cn/jetpack/androidx/releases/databinding?hl=en)
   > [Android Gradle 插件 1.5.0推出的新特性](https://developer.android.com/build/releases/past-releases/agp-1-5-0-release-notes?hl=zh-cn)
   > [Android Gradle 插件 4.0.0开始放在buildFeatures](https://developer.android.com/build/releases/past-releases/agp-4-0-0-release-notes?hl=zh-cn)
>- 网络框架1
   > [retrofit2](https://github.com/square/retrofit/) + [协程](https://book.kotlincn.net/text/coroutines-overview.html)
   > [协程上下文与调度器 中文文档](https://book.kotlincn.net/text/coroutine-context-and-dispatchers.html)
   > [协程上下文与调度器 英文文档](https://kotlinlang.org/docs/coroutine-context-and-dispatchers.html#thread-local-data)
>- 网络框架2
   > retrofit2 + Rxjava3 + rxandroid
>- 日志框架
   > [okhttp3:logging-interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor)
>- 数据库
   > [room](https://developer.android.com/jetpack/androidx/releases/room?hl=en#kts)
>- api
   > [玩Android 开放API](https://www.wanandroid.com/blog/show/2)
>- Gradle依赖统一版本管理
   > [compositebuild](https://docs.gradle.org/current/userguide/composite_builds.html)
>- KSP
   > [从 kapt 迁移到 KSP](https://developer.android.com/build/migrate-to-ksp?hl=zh-cn)
   > [KSP官网文档](https://kotlinlang.org/docs/ksp-quickstart.html)
>- [TextInputEditText](https://developer.android.google.cn/reference/com/google/android/material/textfield/TextInputEditText?hl=en)

### 提醒

>- 开启Databinding数据绑定仍需要在模块中启用 kapt。在使用数据绑定的模块中，不能移除 kapt。
>- 创建ViewModel方式
   > 在BaseActivity和BaseFragment里统一通过ViewModelProvider创建ViewModel
>- 如果没有封装成统一的方式，独立创建ViewModel
   >在gradle里依赖androidx.activity:activity-ktx:xxx
   >在Activity里，可以通过 by viewModels()
   >在gradle里依赖androidx.fragment:fragment-ktx:xxx
   >在Fragment里，可以通过 by activityViewModels()

### 遇到的问题

> Kotlin搭建MVVM, 使用DataBinding出现：XXX Unresolved reference: BR

### 解决问题方案

> 生成kapt，在模块的build.gradle.kts中添加Kotlin-apt插件

```bash
plugins {
    id("kotlin-kapt")
}
android {
    kapt{
        generateStubs = true
    }
}
```

