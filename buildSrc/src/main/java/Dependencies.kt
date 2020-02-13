object Dependencies {

    // plugins
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    // libraries
    const val androidAppCompat = "androidx.appcompat:appcompat:${Versions.androidAppCompat}"
    const val androidKtxCore = "androidx.core:core-ktx:${Versions.androidKtxCore}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    // lint
    const val lint = "com.android.tools.lint:lint:${Versions.lint}"
    const val lintApi = "com.android.tools.lint:lint-api:${Versions.lint}"
    const val lintChecks = "com.android.tools.lint:lint-checks:${Versions.lint}"
    const val lintTests = "com.android.tools.lint:lint-tests:${Versions.lint}"

    // tests
    const val junit = "junit:junit:${Versions.jUnit}"
    const val junitJupiterApi = "org.junit.jupiter:junit-jupiter-api:${Versions.junitJupiter}"
    const val junitJupiterEngine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junitJupiter}"
    const val junitJupiterParams = "org.junit.jupiter:junit-jupiter-params:${Versions.junitJupiter}"
    const val junitVintageEngine = "org.junit.vintage:junit-vintage-engine:${Versions.junitVintage}"
}