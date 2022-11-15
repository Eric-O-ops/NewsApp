package com.geektech.newsapp

import android.app.Application
import com.geektech.newsapp.servicelocator.appModule
import com.geektech.newsapp.servicelocator.dataModule
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