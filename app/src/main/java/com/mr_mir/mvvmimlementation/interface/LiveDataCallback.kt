package com.mr_mir.mvvmimlementation.`interface`

import com.mr_mir.mvvmimlementation.model.ModelClass
import com.mr_mir.mvvmimlementation.repository.StatusCheck

/**
 * Created by Shitab Mir on 12,July,2020
 */
interface LiveDataCallback {

    fun getLiveDataResponse(response: StatusCheck<List<ModelClass?>?>)

}