package com.fabiocarballo.rules

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.Issue

class IssueRegistry : IssueRegistry() {

    override val issues: List<Issue>
        get() = listOf(AndroidLogDetector.ISSUE)
}