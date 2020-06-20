package com.mr_mir.mvvmimlementation.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mr_mir.mvvmimlementation.model.ModelClass
import com.mr_mir.mvvmimlementation.retrofit.ApiUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Shitab Mir on 20,June,2020
 */
object ShitabsRepository {

    fun getData(path: String): LiveData<StatusCheck<List<ModelClass?>?>> {

        val data: MutableLiveData<StatusCheck<List<ModelClass?>?>> = MutableLiveData()

        data.value = StatusCheck.loading()

        ApiUtil.getApiService()
            .getData(path)?.enqueue(object : Callback<List<ModelClass?>?> {

                override fun onResponse(
                    call: Call<List<ModelClass?>?>,
                    response: Response<List<ModelClass?>?>
                ) {
                    if (response.isSuccessful) {
                        data.value = StatusCheck.success(response.body())
                    } else{
                        data.value = StatusCheck.error(response.errorBody()?.string() ?: "Failed to get data.")
                    }
                }

                override fun onFailure(call: Call<List<ModelClass?>?>, t: Throwable) {
                    data.value = StatusCheck.error(t.localizedMessage ?: "Failed to get data.")
                }

            })

        return data
    }

}