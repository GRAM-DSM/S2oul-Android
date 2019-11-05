package com.newgram.s2oul_android.searchResult

import android.os.Bundle
import android.util.Log
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.entity.ShowResult
import kotlinx.android.synthetic.main.activity_result_detail.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class SearchResultActivity : AppCompatActivity(), SearchResultContract.View {

    override lateinit var presenter: SearchResultContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_detail)

        search_et.setText(intent.getStringExtra("result"))
        Log.d("searchresult", intent.getStringExtra("result"))
        supportFragmentManager.beginTransaction().run {
            replace(
                R.id.search_detail_frame,
                SearchResultShowFragment()
            )
                .commit()
        }
        search_radio_group.setOnCheckedChangeListener(radioCheckedChangeListener)

        search_filter_iv.onClick{
            startActivity<SearchFilterActivity>()
        }
    }

    override fun showResult(items: Array<ShowResult>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val radioCheckedChangeListener = RadioGroup.OnCheckedChangeListener { item, i ->
        val transaction = supportFragmentManager.beginTransaction()
        when(item.checkedRadioButtonId) {
            R.id.search_show_radio -> {
                transaction.replace(
                    R.id.search_detail_frame,
                    SearchResultShowFragment()
                )
                transaction.commit()
                return@OnCheckedChangeListener
            }
            R.id.search_place_radio -> {
                transaction.replace(
                    R.id.search_detail_frame,
                    SearchResultPlaceFragment()
                )
                transaction.commit()
                return@OnCheckedChangeListener
            }
        }

        false
    }


}
