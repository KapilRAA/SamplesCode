package com.kotlinsamples.mvvm.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kotlinsamples.repository.TimeSlotRepo

class TimeViewModelFactory(private val timeSlotRepo: TimeSlotRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TimeViewModel(timeSlotRepo) as T
    }
}