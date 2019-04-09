package com.wd.tech.mypushs.contract

import android.content.Context
import com.wd.tech.mypush.kotlin.LoginBean
import com.wd.tech.mypush.kotlin.RegisterBean
import com.wd.tech.mypush.kotlin.RequestCallBack
import java.util.*


interface MyContract {

     interface MyPresenter{

         fun  login(hashMap: HashMap<String,String>,string: String)

         fun  register(hashMap: HashMap<String, String>,string: String)

         fun  product(hashMap: HashMap<String, String>,string: String)
     }
  interface  MyModel{
       fun login(hashMap: HashMap<String, String>,string: String,requestCallBack: RequestCallBack)

       fun register(hashMap: HashMap<String, String>,string: String,requestCallBack: RequestCallBack)

       fun  product(hashMap: HashMap<String, String>,string: String,requestCallBack: RequestCallBack)


  }
   interface MyView{
        fun  success(objects: Any)
        fun   onfair(string: String)

    }

    /*interface MyView<T>{
        fun  success(t:T)
        fun   onfair(string: String)

    }*/
}