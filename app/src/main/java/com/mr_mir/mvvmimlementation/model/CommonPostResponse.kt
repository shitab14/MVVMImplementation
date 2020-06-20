package com.mr_mir.mvvmimlementation.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Shitab Mir on 20,June,2020
 */
data class CommonPostResponse(
    //use retrofit library
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String
)