plugins {
    id("com.android.library")
    id("kotlin-android")
}

defaultAndroidConfiguration()

publishAndroid(
        "koin-androidx-ext",
        "Koin project - koin-androidx-ext"
)

dependencies {
    // Koin
    api(project(":koin-core-ext"))
    api(project(":koin-androidx-viewmodel"))

    // Architecture ViewModel
    api("androidx.lifecycle:lifecycle-extensions:${Version.Dependency.androidxArch}") {
        exclude(module = "lifecycle-livedata")
        exclude(module = "lifecycle-service")
        exclude(module = "lifecycle-process")
        exclude(module = "runtime")
        exclude(group = "androidx.legacy")
    }
    api("androidx.lifecycle:lifecycle-viewmodel-savedstate:${Version.Dependency.androidxSavedState}") {
        exclude(module = "lifecycle-livedata")
        exclude(module = "lifecycle-service")
        exclude(module = "lifecycle-process")
        exclude(module = "runtime")
        exclude(group = "androidx.legacy")
    }

    // Test
    testImplementation(project(":koin-test"))
    testImplementation("org.mockito:mockito-inline:${Version.Test.mockito}")
}