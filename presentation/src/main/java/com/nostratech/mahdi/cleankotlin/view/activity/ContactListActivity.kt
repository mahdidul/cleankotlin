package com.nostratech.mahdi.cleankotlin.view.activity

import android.os.Bundle
import com.nostratech.mahdi.cleankotlin.R
import com.nostratech.mahdi.cleankotlin.viewmodel.ContactListViewModel


class ContactListActivity : BaseActivity<ContactListViewModel>() {
    override val viewModelClass: Class<ContactListViewModel>
        get() = ContactListViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
