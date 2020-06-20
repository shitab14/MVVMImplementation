package com.mr_mir.mvvmimlementation.retrofit

import com.mr_mir.mvvmimlementation.model.ModelClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Shitab Mir on 20,June,2020
 */
interface ApiEndpoints {

    @GET("/jsons/{path_var}/retrofit.json")
    fun getData(@Path("path_var") pathVar: String?): Call<List<ModelClass?>?>?

}