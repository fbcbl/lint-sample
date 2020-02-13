package com.fabiocarballo.rules

import com.android.tools.lint.checks.infrastructure.LintDetectorTest
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Issue
import com.fabiocarballo.rules.Stubs.ANDROID_LOG_IMPL_JAVA
import com.fabiocarballo.rules.Stubs.CUSTOM_LOG_IMPL_JAVA
import org.junit.jupiter.api.Test

class AndroidLogDetectorTest : LintDetectorTest() {

    @Test
    fun shouldDetectUsageOfAndroidLog() {
        val stubFile = kotlin(
            """
            package com.fabiocarballo.lint

            import android.util.Log

            class Dog {

                fun bark() {
                    Log.d(TAG, "woof! woof!")
                }
            }
        """
        ).indented()

        val lintResult = lint()
            .files(ANDROID_LOG_IMPL_JAVA, stubFile)
            .run()

        lintResult
            .expectErrorCount(1)
            .expect(
                """
             src/com/fabiocarballo/lint/Dog.kt:8: Error: android.util.Log usage is forbidden. [AndroidLogDetector]
                     Log.d(TAG, "woof! woof!")
                     ~~~~~~~~~~~~~~~~~~~~~~~~~
             1 errors, 0 warnings
         """.trimIndent()
            )
    }

    @Test
    fun shouldNotDetectIfLogImportIsDifferent() {
        val fileToEvaluate = kotlin(
            """
            package com.fabiocarballo.lint

            import com.fabiocarballo.lint.Log

            class Dog {

                fun bark() {
                    Log.d(TAG, "woof! woof!")
                }
            }
        """
        ).indented()

        val lintResult = lint()
            .files(CUSTOM_LOG_IMPL_JAVA, fileToEvaluate)
            .run()

        lintResult
            .expectClean()
    }

    override fun getDetector(): Detector = AndroidLogDetector()

    override fun getIssues(): MutableList<Issue> = mutableListOf(AndroidLogDetector.ISSUE)
}