package com.mr_mir.mvvmimlementation.retrofit

/**
 * Created by Shitab Mir on 20,June,2020
 */

class ApiUtil {
    companion object {
        fun getApiService(): ApiEndpoints{
            val BASE_URL: String = "https://shitab14.github.io"
            return RetrofitBuilder.getClient(BASE_URL)!!.create(ApiEndpoints::class.java)
        }
    }
}