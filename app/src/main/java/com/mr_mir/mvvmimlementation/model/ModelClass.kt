package com.mr_mir.mvvmimlementation.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Shitab Mir on 20,June,2020
 */
data class ModelClass (
    @field:SerializedName("id")
    private val id: String? = null,

    @field:SerializedName("data")
    private val data: String? = null
): Serializable