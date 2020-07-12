package com.mr_mir.mvvmimlementation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mr_mir.mvvmimlementation.`interface`.LiveDataCallback
import com.mr_mir.mvvmimlementation.repository.StatusCheck
import com.mr_mir.mvvmimlementation.model.ModelClass
import com.mr_mir.mvvmimlementation.repository.ShitabsRepository

/**
 * Created by Shitab Mir on 20,June,2020
 */
class ShitabsViewModel: ViewModel() {

    var _myLiveData = MutableLiveData<StatusCheck<List<ModelClass?>?>>()
//    private var _myLiveData = MediatorLiveData<StatusCheck<List<ModelClass?>?>>()
//    val myLiveData: LiveData<StatusCheck<List<ModelClass?>?>> = _myLiveData

    fun getData(path: String){
        ShitabsRepository.getData(path, object : LiveDataCallback{
            override fun getLiveDataResponse(response: StatusCheck<List<ModelClass?>?>) {
                _myLiveData.value = response
            }

        })
        /*_myLiveData.addSource(ShitabsRepository.getData(path)){ it ->
            _myLiveData.value = it
        }*/
    }



    /*fun removeSourceForData(path: String){
        _myLiveData.removeSource(ShitabsRepository.getData(path))
    }*/

}