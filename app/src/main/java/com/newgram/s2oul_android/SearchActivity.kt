package com.newgram.s2oul_android

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Single
import kotlinx.android.synthetic.main.activity_search.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class SearchActivity : AppCompatActivity() {

    val searchHistoryAdapter by lazy {SearchHistoryAdapter(this, dummy)}
    var list = dummy
    val rxword: Single<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

//        searchHistory_rv.adapter = searchHistoryAdapter
//        searchHistory_rv.layoutManager = layoutManager
//        searchHistory_rv.setHasFixedSize(true)

        search_cancel_iv.onClick { startActivity<SearchDetailActivity>() }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        return super.onCreateOptionsMenu(menu)
    }

}
