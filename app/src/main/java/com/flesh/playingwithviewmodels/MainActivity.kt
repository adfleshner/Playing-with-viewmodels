package com.flesh.playingwithviewmodels

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.flesh.playingwithviewmodels.counter.CounterActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun goToCounter(view: View) {
        startActivity(Intent(view.context, CounterActivity::class.java))
    }

}

