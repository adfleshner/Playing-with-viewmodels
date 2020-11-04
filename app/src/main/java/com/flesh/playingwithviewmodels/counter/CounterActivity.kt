package com.flesh.playingwithviewmodels.counter

import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.flesh.playingwithviewmodels.R
import com.flesh.playingwithviewmodels.databinding.ActivityCounterBinding

class CounterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model: CounterViewModel by viewModels()
        setMainActivityDataBinding(R.layout.activity_counter, model)
    }
}

private fun AppCompatActivity.setMainActivityDataBinding(
    @LayoutRes layoutId: Int,
    viewModelToBind: CounterViewModel
) {
    val binding: ActivityCounterBinding = DataBindingUtil.setContentView(this, layoutId)
    // Specify the current activity as the lifecycle owner.
    binding.lifecycleOwner = this
    binding.viewmodel = viewModelToBind
}