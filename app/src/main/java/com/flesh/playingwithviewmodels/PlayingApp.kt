package com.flesh.playingwithviewmodels

import android.app.Application
import com.github.ajalt.timberkt.Timber

class PlayingApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

}