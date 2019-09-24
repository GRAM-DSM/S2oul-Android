package com.newgram.s2oul_android.placeDetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.newgram.s2oul_android.R

class PlaceDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_detail)

        intent.getStringExtra("name")
    }
}
