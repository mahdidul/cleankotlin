package com.nostratech.mahdi.cleankotlin.di.module

import android.content.Context
import com.nostratech.mahdi.cleankotlin.view.ContactPreference
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PreferenceModule {

    @Singleton
    @Provides
    fun providesGibbyPreference(context: Context): ContactPreference {
        return ContactPreference(context)
    }
}