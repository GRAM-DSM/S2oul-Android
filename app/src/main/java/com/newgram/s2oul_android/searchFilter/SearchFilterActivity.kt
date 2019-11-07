package com.newgram.s2oul_android.searchFilter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.newgram.s2oul_android.R
import kotlinx.android.synthetic.main.activity_search_filter.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class SearchFilterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_filter)

        searchFilter_accept_btn.onClick {
            finish()
        }
        search_filter_cancel_iv.onClick {
            finish()
        }
    }
}
