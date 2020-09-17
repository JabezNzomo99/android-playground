package com.jabezmagomere.playground

import android.app.Application
import com.facebook.stetho.Stetho
import com.jabezmagomere.core.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class PlaygroundApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initStetho()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@PlaygroundApplication)
            modules(listOf(networkModule))
        }
    }

    private fun initStetho() {
        Stetho.initializeWithDefaults(this)
    }
}