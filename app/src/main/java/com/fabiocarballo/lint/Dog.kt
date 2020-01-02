package com.fabiocarballo.lint

import android.util.Log

class Dog {

    fun bark() {
        Log.d(TAG, "woof! woof!")
    }

    companion object {
        private const val TAG = "Sample"
    }
}