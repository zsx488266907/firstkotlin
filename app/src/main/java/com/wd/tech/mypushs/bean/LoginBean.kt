package com.wd.tech.mypush.kotlin


/*
data class LoginBean (

        val message: String,
        val result: ResultBean,
        val status: String
)

data  class ResultBean (

        val sessionId: String,
        val userId: Int ,
        val userInfo: UserInfoBean
)

data   class UserInfoBean (
        val birthday: Long ,
        val headPic: String ,
        val id: Int ,
        val lastLoginTime: Long ,
        val nickName: String,
        val phone: String,
        val sex: Int
)*/

    data class LoginBean(
    val message: String,
    val result: Result,
    val status: String
)

data class Result(
    val headPic: String,
    val nickName: String,
    val phone: String,
    val pwd: String,
    val sessionId: String,
    val userId: Int,
    val userName: String,
    val whetherFaceId: Int,
    val whetherVip: Int
)
