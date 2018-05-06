package com.nostratech.mahdi.cleankotlin.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import javax.inject.Inject

/**
 * Created by Mahdi on 06/05/18.
 * Part of clean_kotlin
 */
class ContactListFragmentViewModel @Inject constructor() : BaseViewModel() {

    enum class NavItem {
        HOME, ORDER, INBOX, PROFILE
    }

    private val mutableNavItem = MutableLiveData<NavItem>()

    val navItem: LiveData<NavItem>
        get() = mutableNavItem

    init {
        mutableNavItem.value = NavItem.HOME
    }

    fun setNavItem(navItem: NavItem) {
        mutableNavItem.value = navItem
    }
}