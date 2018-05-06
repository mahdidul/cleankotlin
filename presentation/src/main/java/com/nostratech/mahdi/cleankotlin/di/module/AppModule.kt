package com.nostratech.mahdi.cleankotlin.di.module

import android.content.Context
import com.nostratech.mahdi.cleankotlin.ContactApp
import com.nostratech.mahdi.cleankotlin.di.RxSchedulers
import dagger.Module
import dagger.Provides
import org.greenrobot.eventbus.EventBus
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun provideContext(application: ContactApp): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun provideRxSchedulers(): RxSchedulers {
        return RxSchedulers()
    }

    @Singleton
    @Provides
    fun providesEventBus(): EventBus = EventBus.getDefault()
}