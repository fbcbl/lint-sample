object Dependencies {

    // plugins
    val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
    val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    // libraries
    val androidAppCompat = "androidx.appcompat:appcompat:${Versions.androidAppCompat}"
    val androidKtxCore = "androidx.core:core-ktx:${Versions.androidKtxCore}"
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    // lint
    val lintApi = "com.android.tools.lint:lint-api:${Versions.lint}"
    val lintChecks = "com.android.tools.lint:lint-checks:${Versions.lint}"
}