package com.newgram.s2oul_android.info

import android.os.Bundle
import android.util.Log
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.newgram.s2oul_android.R
import kotlinx.android.synthetic.main.activity_info_filter.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class InfoFilterActivity : AppCompatActivity() {

    var genre = "all"
    var sort = "date"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_filter)

        info_sort_radio_group.setOnCheckedChangeListener(sortChangeListener)
        info_filter_all_radio.requestFocus()

        info_filter_accept_btn.onClick {
//            val intent = Intent()
//            intent.putExtra("genre", "${currentFocus}")
//            intent.putExtra("sort", sort)
//            setResult(Activity.RESULT_OK, intent)
//            finish()
            Log.d("안뇽", "${(info_filter_all_radio.id)}")
            Log.d("현재 포커스","${currentFocus.id}")
            finish()
        }

        info_filter_cancel_iv.onClick {
            finish()
        }
    }

    private val sortChangeListener = RadioGroup.OnCheckedChangeListener { item, i ->
        when(item.checkedRadioButtonId) {
            R.id.info_filter_show_radio -> {
                sort = "date"
            }
            R.id.info_filter_alphabet_radio -> {
                sort = "alphabet"
            }
        }

        false
    }

}
