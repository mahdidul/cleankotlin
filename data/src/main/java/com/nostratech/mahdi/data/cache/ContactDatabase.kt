package com.nostratech.mahdi.data.cache

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.nostratech.mahdi.data.cache.dao.ContactDao

@Database(entities = [
    ContactData::class,
    ContactDataSetting::class],
        version = 1)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao
}