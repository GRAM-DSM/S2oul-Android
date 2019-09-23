package com.newgram.s2oul_android

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Single
import kotlinx.android.synthetic.main.activity_search.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class SearchActivity : AppCompatActivity() {

    val searchHistoryAdapter by lazy {SearchHistoryAdapter(this, dummy)}
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

//        search_et.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable?) {
//                // 입력이 끝났을
//                var text = search_et.text.toString()
//                Log.d("SearchActivity", text)
//                text.let {searchHistoryAdapter.filter(text)}
//
//            }
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                //입력되는 텍스트에 변화가 있을 때
//            }
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//                // 입력하기 전에
//            }
//        })

        val searchView = findViewById<SearchView>(R.id.search_et)
        searchView?.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    searchHistoryAdapter.filter(query)}
                return false
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        return super.onCreateOptionsMenu(menu)
    }

}
