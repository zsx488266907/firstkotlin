package com.wd.tech.mypush.kotlin


import com.wd.tech.mypushs.bean.HomeBean

import okhttp3.ResponseBody
import retrofit2.http.*
import java.util.*

interface RetrofitService {
    //dd

    @POST
    @FormUrlEncoded
    fun login(@Url string: String, @FieldMap hashMap: HashMap<String,String>):io.reactivex.Observable<LoginBean>

    @POST
    @FormUrlEncoded
    fun register(@Url string: String,@FieldMap hashMap: HashMap<String, String>) :io.reactivex.Observable<RegisterBean>

    @GET
    fun   Home(@Url string: String, @QueryMap hashMap: HashMap<String, String>) :io.reactivex.Observable<HomeBean>


}