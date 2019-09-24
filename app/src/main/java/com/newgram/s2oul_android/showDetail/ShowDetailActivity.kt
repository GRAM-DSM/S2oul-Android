package com.newgram.s2oul_android.showDetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.newgram.s2oul_android.R

class ShowDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)

        intent.getStringExtra("name")

    }
}
