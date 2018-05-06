package com.nostratech.mahdi.cleankotlin.view.fragment

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<VM : ViewModel> : DaggerFragment() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    protected lateinit var viewModel: VM

}