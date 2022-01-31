package com.alex.app.getcepdataapp

import android.app.Application
import com.alex.app.getcepdataapp.data.di.dataModule
import com.alex.app.getcepdataapp.di.appModule
import com.alex.app.getcepdataapp.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MyApp)
            modules(LIST_KOIN_MODULES)
        }
    }

    companion object {
        private val LIST_KOIN_MODULES = listOf(
            appModule,
            domainModule,
            dataModule
        )
    }
}