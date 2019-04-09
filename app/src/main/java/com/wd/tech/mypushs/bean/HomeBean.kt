package com.wd.tech.mypushs.bean

data class HomeBean (


    val message: String,

    val status: String,

    val result: List<ResultBean>
    )

 data   class ResultBean (val followMovie: Int,
                          val id: Int,
                          val imageUrl: String,
                          val name: String,
                          val rank: Int,
                          val summary: String)





