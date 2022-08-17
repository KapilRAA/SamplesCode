package com.kotlinsamples.retrofit

import com.kotlinsamples.models.TimeSlotModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/customer/app/time_slots_new.php")
    suspend fun getTimeSlot() : Response<TimeSlotModel>
}