package com.newgram.s2oul_android

import android.app.Application
import com.bumptech.glide.Glide

class App: Application() {
    override fun onLowMemory() {
        super.onLowMemory()
        Glide.get(this).clearMemory()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        Glide.get(this).trimMemory(level)
    }
}