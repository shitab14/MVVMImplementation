package com.mr_mir.mvvmimlementation.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mr_mir.mvvmimlementation.`interface`.LiveDataCallback
import com.mr_mir.mvvmimlementation.model.ModelClass
import com.mr_mir.mvvmimlementation.retrofit.ApiUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Shitab Mir on 20,June,2020
 */
object ShitabsRepository {

    fun getData(path: String, callback: LiveDataCallback) {

        //val data: MutableLiveData<StatusCheck<List<ModelClass?>?>> = MutableLiveData()

        callback.getLiveDataResponse(StatusCheck.loading())

        ApiUtil.getApiService()
            .getData(path)?.enqueue(object : Callback<List<ModelClass?>?> {

                override fun onResponse(
                    call: Call<List<ModelClass?>?>,
                    response: Response<List<ModelClass?>?>
                ) {
                    if (response.isSuccessful) {
                        callback.getLiveDataResponse(StatusCheck.success(response.body()))
                    } else{
                        callback.getLiveDataResponse(StatusCheck.error(response.errorBody()?.string() ?: "Failed to get data."))
                    }
                }

                override fun onFailure(call: Call<List<ModelClass?>?>, t: Throwable) {
                    callback.getLiveDataResponse(StatusCheck.error(t.localizedMessage ?: "Failed to get data."))
                }

            })

    }

}