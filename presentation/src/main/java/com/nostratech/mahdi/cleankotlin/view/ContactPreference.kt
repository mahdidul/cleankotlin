package com.nostratech.mahdi.cleankotlin.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

class ContactPreference(private val context: Context) {

    companion object {
        const val PUSH_TOKEN = "push_token"
        const val APP_UNIQUE_ID = "app_unique_id"
    }
    private val prefs: SharedPreferences by lazy { context.getSharedPreferences("com.nostratech.mahdi.cleankotlin", Context.MODE_PRIVATE) }

    var pushToken: String
        get() = findPreference(PUSH_TOKEN, "")
        set(value) {
            putPreference(PUSH_TOKEN, value)
        }

    var appUniqueId: String
        get() = findPreference(APP_UNIQUE_ID, "")
        set(value) {
            putPreference(APP_UNIQUE_ID, value)
        }

    @Suppress("UNCHECKED_CAST")
    private fun <T> findPreference(name: String, default: T?): T = with(prefs) {
        val res: Any = when (default) {
            is Long -> getLong(name, default)
            is String -> getString(name, default)
            is Int -> getInt(name, default)
            is Boolean -> getBoolean(name, default)
            is Float -> getFloat(name, default)
            else -> throw IllegalArgumentException("Type is unknown")
        }
        res as T
    }

    @SuppressLint("CommitPrefEdits")
    private fun <T> putPreference(name: String, value: T) = with(prefs.edit()) {
        when (value) {
            is Long -> putLong(name, value)
            is String -> putString(name, value)
            is Int -> putInt(name, value)
            is Boolean -> putBoolean(name, value)
            is Float -> putFloat(name, value)
            else -> throw IllegalArgumentException("This type can't be saved into Preferences")
        }.apply()
    }
}