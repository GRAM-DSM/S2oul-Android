package com.newgram.s2oul_android.searchResult

import android.content.Intent
import android.os.Bundle
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.searchFilter.SearchFilterActivity
import com.newgram.s2oul_android.searchResult.showSearch.ShowSearchFragment
import com.newgram.s2oul_android.searchResult.theaterSearch.TheaterSearchFragment
import kotlinx.android.synthetic.main.activity_result_detail.*
import org.jetbrains.anko.sdk27.coroutines.onClick



class SearchResultActivity : AppCompatActivity() {

    private val REQUEST_ACT = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_detail)

        search_et.setText(intent.getStringExtra("word"))
        supportFragmentManager.beginTransaction().run {
            replace(
               R.id.search_detail_frame, ShowSearchFragment()
            ).commit()
        }

        search_radio_group.setOnCheckedChangeListener(radioCheckedChangeListener)

        search_filter_iv.onClick{
            val intent = Intent(this@SearchResultActivity, SearchFilterActivity::class.java)
            startActivityForResult(intent, REQUEST_ACT)
        }

        search_cancel_iv.onClick{
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


    }

    private val radioCheckedChangeListener = RadioGroup.OnCheckedChangeListener { item, i ->
        val transaction = supportFragmentManager.beginTransaction()
        when(item.checkedRadioButtonId) {
            R.id.search_show_radio -> {
                transaction.replace(
                   R.id.search_detail_frame,
                    ShowSearchFragment()
                )
                transaction.commit()
                return@OnCheckedChangeListener
            }
            R.id.search_place_radio -> {
                transaction.replace(
                    R.id.search_detail_frame,
                    TheaterSearchFragment()
                )
                transaction.commit()
                return@OnCheckedChangeListener
            }
        }

        false
    }


}
