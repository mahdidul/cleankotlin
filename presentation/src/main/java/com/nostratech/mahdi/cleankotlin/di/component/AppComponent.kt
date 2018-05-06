package com.nostratech.mahdi.cleankotlin.di.component

import com.nostratech.mahdi.cleankotlin.ContactApp
import com.nostratech.mahdi.cleankotlin.di.ViewModelBuilder
import com.nostratech.mahdi.cleankotlin.di.module.AppModule
import com.nostratech.mahdi.cleankotlin.di.module.ContactListModule
import com.nostratech.mahdi.cleankotlin.di.module.PreferenceModule
import com.nostratech.mahdi.cleankotlin.di.module.ServiceModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    ContactListModule::class,
    AndroidSupportInjectionModule::class,
    ViewModelBuilder::class,
    ServiceModule::class,
    PreferenceModule::class])
interface AppComponent : AndroidInjector<ContactApp> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<ContactApp>() {

        abstract override fun build(): AppComponent
    }
}