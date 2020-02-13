package com.fabiocarballo.rules

import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.checks.infrastructure.TestFiles.java

object Stubs {

    /**
     * [TestFile] containing Log.java from the Android SDK.
     *
     * This is a hacky workaround for the Android SDK not being included on the Lint test harness
     * classpath. Ideally, we'd specify ANDROID_HOME as an environment variable.
     */
    val ANDROID_LOG_IMPL_JAVA: TestFile = java(
        """
                package android.util;
                
                public class Log {
                    public static void d(String tag, String msg) {
                        // Stub!
                    }
                }
            """).indented()


    val CUSTOM_LOG_IMPL_JAVA: TestFile = java(
        """
                package com.fabiocarballo.lint;
                
                public class Log {
                    public static void d(String tag, String msg) {
                        // Stub!
                    }
                }
            """.trimIndent()
    )

}
