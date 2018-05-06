package com.nostratech.mahdi.cleankotlin.di.module

import android.arch.lifecycle.ViewModel
import com.nostratech.mahdi.cleankotlin.view.activity.ContactListActivity
import com.nostratech.mahdi.cleankotlin.viewmodel.ContactListViewModel
import com.nostratech.mahdi.cleankotlin.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ContactListModule {

    @ContributesAndroidInjector(modules = [(ContactListFragmentModule::class)])
    abstract fun contactListActivity(): ContactListActivity

    @Binds
    @IntoMap
    @ViewModelKey(ContactListViewModel::class)
    abstract fun bindContactListViewModel(viewModel: ContactListViewModel): ViewModel
}