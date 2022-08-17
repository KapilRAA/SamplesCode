package com.kotlinsamples.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.kotlinsamples.R
import com.kotlinsamples.databinding.ActivityMainBinding
import com.kotlinsamples.mvvm.view.SimpleList

class SplashPage : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Handler().postDelayed(Runnable {
            val intent = Intent(this,SimpleList ::class.java)
            startActivity(intent)
        },2000)

    }
}