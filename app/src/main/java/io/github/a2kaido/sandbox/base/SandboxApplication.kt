package io.github.a2kaido.sandbox.base

import android.app.Application
import io.github.a2kaido.sandbox.base.di.koinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@Suppress("unused")
class SandboxApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SandboxApplication)
            modules(koinModules)
        }
    }
}