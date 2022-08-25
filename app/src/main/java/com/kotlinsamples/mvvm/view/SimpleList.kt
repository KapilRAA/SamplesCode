package com.kotlinsamples.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.kotlinsamples.R
import com.kotlinsamples.databinding.ActivitySimpleListBinding
import com.kotlinsamples.mvvm.viewmodels.TimeViewModel
import com.kotlinsamples.mvvm.viewmodels.TimeViewModelFactory
import com.kotlinsamples.repository.TimeSlotRepo
import com.kotlinsamples.retrofit.ApiInterface
import com.kotlinsamples.retrofit.RetrofitHelper

class SimpleList : AppCompatActivity() {
    lateinit var simpleListBinding :ActivitySimpleListBinding
    lateinit var timeViewModel: TimeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        simpleListBinding = ActivitySimpleListBinding.inflate(layoutInflater)
//        val view = simpleListBinding.root
//        setContentView(view)
        simpleListBinding = DataBindingUtil.setContentView(this, R.layout.activity_simple_list)

        simpleListBinding.text.text = "MY Name is Kapil"
       val apiInterface = RetrofitHelper.getInstance().create(ApiInterface::class.java)
        val timeSlotRepo = TimeSlotRepo(apiInterface)
        timeViewModel = ViewModelProvider(this,TimeViewModelFactory(timeSlotRepo)).get(TimeViewModel::class.java)

        timeViewModel.timeSlot.observe(this, Observer {
            Log.e("Response", Gson().toJson(it.all_time_slots))
        })

    }
}