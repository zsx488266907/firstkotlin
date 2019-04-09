package com.wd.tech.mypushs.model

import android.annotation.SuppressLint
import android.content.Context
import android.system.Os.accept
import com.wd.tech.mypush.kotlin.*
import com.wd.tech.mypushs.api.MyApi
import com.wd.tech.mypushs.bean.HomeBean
import com.wd.tech.mypushs.contract.MyContract
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import java.util.HashMap

class MyModel : MyContract.MyModel {
    @SuppressLint("CheckResult")
    override fun login(hashMap: HashMap<String, String>, string: String, requestCallBack: RequestCallBack) {
        RetrofitUtil.instance.getSerive(RetrofitService::class.java)
                .login(string, hashMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Consumer<LoginBean> {
                    override fun accept(loginBean: LoginBean) {
                        if (requestCallBack != null) {
                            requestCallBack.success(loginBean)
                        }
                    }
                },
                        Consumer {
                            if (requestCallBack != null) {
                                requestCallBack.onfair("网络请求失败,请查看你的设备")
                            }

                        }
                )
    }

    @SuppressLint("CheckResult")
    override fun register(hashMap: HashMap<String, String>, string: String, requestCallBack: RequestCallBack) {
        RetrofitUtil.instance.getSerive(RetrofitService::class.java)
                .register(string, hashMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Consumer<RegisterBean> {
                    override fun accept(t: RegisterBean) {
                        if (requestCallBack != null) {
                            requestCallBack.success(t)
                        }
                    }
                }, Consumer {
                    if (requestCallBack != null) {
                        requestCallBack.onfair("失败")
                    }

                })
    }

    @SuppressLint("CheckResult")
    override fun product(hashMap: HashMap<String, String>, string: String, requestCallBack: RequestCallBack) {
        RetrofitUtil.instance.getSerive(RetrofitService::class.java)
                .Home(MyApi.PRODUCR_URL, hashMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Consumer<HomeBean> {
                    override fun accept(t: HomeBean) {
                        if (requestCallBack != null) {
                            requestCallBack.success(t)
                        }
                    }
                }, Consumer {
                    if (requestCallBack != null) {
                        requestCallBack.onfair("网络失败")
                    }
                }

                )
    }


}