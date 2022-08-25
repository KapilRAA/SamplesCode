package com.kotlinsamples.databindingLivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.kotlinsamples.R
import com.kotlinsamples.databinding.ActivityCartBinding
import com.kotlinsamples.databindingLivedata.fragments.ProductFragment

class CartActivity : AppCompatActivity() {
    lateinit var activityCartBinding: ActivityCartBinding
    lateinit var productViewModel: ProductViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityCartBinding = DataBindingUtil.setContentView(this,R.layout.activity_cart)
        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        activityCartBinding.totalCount.text = productViewModel.count.toString()

        startFragment()
    }

    private fun startFragment(){
        val productFragment = ProductFragment()
        val t: FragmentTransaction = supportFragmentManager.beginTransaction()
        t.replace(activityCartBinding.container.id, productFragment).commit()
    }
}