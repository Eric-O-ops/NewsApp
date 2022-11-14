package com.geektech.newsapp

import android.app.Application
import com.geektech.newsapp.di.appModule
import com.geektech.newsapp.di.dataModule
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            modules(appModule, dataModule)

        }
    }
}