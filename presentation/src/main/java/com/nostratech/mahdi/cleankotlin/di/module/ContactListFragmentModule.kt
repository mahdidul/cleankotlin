package com.nostratech.mahdi.cleankotlin.di.module

import android.arch.lifecycle.ViewModel
import com.nostratech.mahdi.cleankotlin.view.fragment.ContactListFragment
import com.nostratech.mahdi.cleankotlin.viewmodel.ContactListFragmentViewModel
import com.nostratech.mahdi.cleankotlin.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ContactListFragmentModule {

    @ContributesAndroidInjector
    abstract fun contactListFragment(): ContactListFragment

    @Binds
    @IntoMap
    @ViewModelKey(ContactListFragmentViewModel::class)
    abstract fun bindContactListFragmentViewModel(viewModel: ContactListFragmentViewModel): ViewModel
}