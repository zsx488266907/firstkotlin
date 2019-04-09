package com.wd.tech.mypush.kotlin

import android.app.Application

class app : Application() {
    override fun onCreate() {
        super.onCreate()
        RetrofitUtil.instance.init(BaseApi.BASE_API)

    }
}