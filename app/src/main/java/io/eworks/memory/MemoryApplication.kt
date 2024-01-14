package io.eworks.memory

import android.app.Application
import android.content.Context

class MemoryApplication : Application() {
    init {
        instance = this
    }

    companion object {
        private var instance: MemoryApplication? = null
        val context: MemoryApplication?
            get() = instance
    }
}