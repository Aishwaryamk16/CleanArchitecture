package com.project.cleanarchitecturesample

import android.app.Application
import com.project.cleanarchitecturesample.di.module.PostModule
import com.project.data.di.module.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

//Declare in the Manifest, android:name
class SampleApplication:Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@SampleApplication)
            modules(listOf(PostModule, NetworkModule))
        }

    }
}