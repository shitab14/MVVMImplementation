package com.mr_mir.mvvmimlementation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.mr_mir.mvvmimlementation.repository.StatusCheck
import com.mr_mir.mvvmimlementation.model.ModelClass
import com.mr_mir.mvvmimlementation.repository.ShitabsRepository

/**
 * Created by Shitab Mir on 20,June,2020
 */
class ShitabsViewModel: ViewModel() {

    private var _medLiveData = MediatorLiveData<StatusCheck<List<ModelClass?>?>>()
    val myLiveData: LiveData<StatusCheck<List<ModelClass?>?>> = _medLiveData

    fun getData(path: String){
        _medLiveData.addSource(ShitabsRepository.getData(path)){ it ->
            _medLiveData.value = it
        }
    }

    fun removeSourceForData(path: String){
        _medLiveData.removeSource(ShitabsRepository.getData(path))
    }

}