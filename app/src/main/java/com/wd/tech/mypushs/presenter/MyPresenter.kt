package com.wd.tech.mypushs.presenter

import android.content.Context
import com.wd.tech.mypush.kotlin.LoginBean
import com.wd.tech.mypush.kotlin.RequestCallBack
import com.wd.tech.mypushs.contract.MyContract
import com.wd.tech.mypushs.model.MyModel
import java.util.HashMap

class MyPresenter : MyContract.MyPresenter {
    lateinit var myModel: MyModel
    lateinit var myView: MyContract.MyView


    constructor(myView: MyContract.MyView) {
        this.myView = myView
        myModel = MyModel()
    }

    override fun login(hashMap: HashMap<String, String>, string: String) {
        myModel.login(hashMap, string, object : RequestCallBack {
            override fun success(t: Any) {
                myView.success(t)
            }

            override fun onfair(string: String) {
                myView.onfair(string)

            }

        })
    }

    override fun register(hashMap: HashMap<String, String>, string: String) {
        myModel.register(hashMap, string, object : RequestCallBack {

            override fun success(t: Any) {
                myView.success(t)
            }

            override fun onfair(string: String) {
                myView.onfair(string)
            }
        })

    }

    override fun product(hashMap: HashMap<String, String>, string: String) {
        myModel.product(hashMap, string, object : RequestCallBack {
            override fun success(t: Any) {
                myView.success(t)
            }

            override fun onfair(string: String) {
                myView.onfair(string)
            }

        })
    }


}