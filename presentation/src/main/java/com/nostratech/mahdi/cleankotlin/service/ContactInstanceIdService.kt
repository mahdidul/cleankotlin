package com.nostratech.mahdi.cleankotlin.service

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService
import com.nostratech.mahdi.cleankotlin.view.ContactPreference
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * Created by Mahdi on 06/05/18.
 * Part of clean_kotlin
 */
class ContactInstanceIdService : FirebaseInstanceIdService() {

    @Inject
    lateinit var contactPreference: ContactPreference

    override fun onCreate() {
        super.onCreate()
        AndroidInjection.inject(this)
        Log.d(TAG, "onCreate contact firebase instance service");
    }

    override fun onTokenRefresh() {
        Log.d(TAG, "onTokenRefresh")
        val refreshedToken = FirebaseInstanceId.getInstance().token
        if (contactPreference.pushToken == "" || contactPreference.pushToken != refreshedToken) {
            refreshedToken?.let {
                Log.d(TAG, "storing firebase refreshed token $refreshedToken")
                contactPreference.pushToken = it
            }
        }
    }

    companion object {
        const val TAG = "GibbyInstanceIdService"
    }
}