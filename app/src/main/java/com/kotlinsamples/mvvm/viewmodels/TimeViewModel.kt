package com.kotlinsamples.mvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlinsamples.models.TimeSlotModel
import com.kotlinsamples.repository.TimeSlotRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TimeViewModel(private val timeSlotRepo: TimeSlotRepo) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            timeSlotRepo.getTimeSlot()
        }
    }

   val  timeSlot : LiveData<TimeSlotModel>
   get() = timeSlotRepo.timeSlotLiveData
}