package com.newgram.s2oul_android

import android.os.Bundle
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_search_detail.*

class SearchDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_detail)

        supportFragmentManager.beginTransaction().run {
            replace(R.id.search_detail_frame, SearchDetailShowFragment())
                .commit()
        }
        search_radio_group.setOnCheckedChangeListener(radioCheckedChangeListener)
    }

    private val radioCheckedChangeListener = RadioGroup.OnCheckedChangeListener { item, i ->
        val transaction = supportFragmentManager.beginTransaction()
        when(item.checkedRadioButtonId) {
            R.id.search_show_radio -> {
                transaction.replace(R.id.search_detail_frame, SearchDetailShowFragment())
                transaction.commit()
                return@OnCheckedChangeListener
            }
            R.id.search_place_radio -> {
                transaction.replace(R.id.search_detail_frame, SearchDetailPlaceFragment())
                transaction.commit()
                return@OnCheckedChangeListener
            }
        }

        false
    }
}
