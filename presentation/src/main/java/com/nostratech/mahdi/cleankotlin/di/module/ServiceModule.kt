package com.nostratech.mahdi.cleankotlin.di.module

import com.nostratech.mahdi.cleankotlin.service.ContactInstanceIdService
import com.nostratech.mahdi.cleankotlin.service.ContactMessagingService
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ServiceModule {

    @ContributesAndroidInjector
    abstract fun contactMessagingService(): ContactMessagingService

    @ContributesAndroidInjector
    abstract fun contactInstanceIdService(): ContactInstanceIdService
}