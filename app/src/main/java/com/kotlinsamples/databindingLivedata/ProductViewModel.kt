package com.kotlinsamples.databindingLivedata

import androidx.lifecycle.ViewModel

class ProductViewModel : ViewModel() {
     var count = 0

    fun addCount(){
        count++
    }

    fun minusCount(){
       count--
    }

    fun totalCount(){
        count
    }
}