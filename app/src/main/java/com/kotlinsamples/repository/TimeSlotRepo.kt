package com.kotlinsamples.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kotlinsamples.models.TimeSlotModel
import com.kotlinsamples.retrofit.ApiInterface

class TimeSlotRepo(private val apiInterface: ApiInterface) {

    private val timeSlotMutableLiveData = MutableLiveData<TimeSlotModel>()
    val timeSlotLiveData:LiveData<TimeSlotModel>
    get() = timeSlotMutableLiveData

    suspend fun getTimeSlot(){
        val result = apiInterface.getTimeSlot()
        if (result?.body() != null){
           timeSlotMutableLiveData.postValue(result.body())
        }
    }
}