package com.newgram.s2oul_android.searchFilter

import android.os.Bundle
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.newgram.s2oul_android.R
import kotlinx.android.synthetic.main.activity_search_filter.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class SearchFilterActivity : AppCompatActivity() {

    var genre = ""
    var sort = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_filter)

        search_sort_radio_group.setOnCheckedChangeListener(sortChangeListener)

        searchFilter_accept_btn.onClick {
            setResult(1)
            finish()
        }
        search_filter_cancel_iv.onClick {
            finish()
        }
    }

    private val sortChangeListener = RadioGroup.OnCheckedChangeListener { item, i ->
        when(item.checkedRadioButtonId) {
            R.id.search_filter_show_radio -> {
                sort = search_filter_show_radio.text.toString()
            }
            R.id.search_filter_place_radio -> {
                sort = search_filter_place_radio.text.toString()
            }
        }

        false
    }

//    private val genreChangeListener = Button.
}
