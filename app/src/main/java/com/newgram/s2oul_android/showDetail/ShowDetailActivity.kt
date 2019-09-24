package com.newgram.s2oul_android.showDetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.newgram.s2oul_android.R
import kotlinx.android.synthetic.main.activity_show_detail.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class ShowDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)

        intent.getStringExtra("name")
        showDetail_place_layout.onClick {
            startActivity<ShowDetailActivity>("name" to "name")
        }

    }
}
