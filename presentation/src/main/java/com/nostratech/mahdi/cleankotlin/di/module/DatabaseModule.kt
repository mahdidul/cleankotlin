package com.nostratech.mahdi.cleankotlin.di.module

import android.arch.persistence.room.Room
import android.content.Context
import com.nostratech.mahdi.data.cache.ContactDatabase
import com.nostratech.mahdi.data.cache.dao.ContactDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): ContactDatabase {
        return Room.databaseBuilder(context, ContactDatabase::class.java, "contact.db")
                // TODO: add migration
                .fallbackToDestructiveMigration()
                .build()
    }

    @Provides
    fun provideUserDao(db: ContactDatabase): ContactDao {
        return db.contactDao()
    }
}