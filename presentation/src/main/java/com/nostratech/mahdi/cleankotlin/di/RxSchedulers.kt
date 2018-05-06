package com.nostratech.mahdi.cleankotlin.di

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RxSchedulers(val disk: Scheduler = Schedulers.single(),
                   val network: Scheduler = Schedulers.io(),
                   val main: Scheduler = AndroidSchedulers.mainThread())