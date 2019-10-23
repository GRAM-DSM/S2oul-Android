package com.newgram.s2oul_android.search

import android.os.Bundle
import android.view.KeyEvent
import android.view.Menu
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.entity.dummy
import com.newgram.s2oul_android.searchResult.SearchDetailActivity
import io.reactivex.Single
import kotlinx.android.synthetic.main.activity_search.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class SearchActivity : AppCompatActivity() {

    val searchHistoryAdapter by lazy {
        SearchHistoryAdapter(
            this,
            dummy
        )
    }
    var list = dummy
    val rxword: Single<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        searchHistory_rv.adapter = searchHistoryAdapter
        searchHistory_rv.layoutManager = layoutManager
        searchHistory_rv.setHasFixedSize(true)

        search_cancel_iv.onClick { finish() }
        search_et.setOnEditorActionListener(object: TextView.OnEditorActionListener{
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                when(actionId) {
                    EditorInfo.IME_NULL -> {}
                    EditorInfo.IME_ACTION_SEARCH -> {
                        startActivity<SearchDetailActivity>("result" to search_et.text.toString())
                        return false
                    }
                }
                return true
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        return super.onCreateOptionsMenu(menu)
    }

}
