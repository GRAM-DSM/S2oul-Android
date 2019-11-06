package com.newgram.s2oul_android.search

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.Menu
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.searchResult.SearchResultActivity
import kotlinx.android.synthetic.main.activity_search.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class SearchActivity : AppCompatActivity(), SearchContract.View {

    override lateinit var presenter: SearchContract.Presenter

    val searchHistoryAdapter by lazy { SearchHistoryAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        presenter = SearchPresenter(this@SearchActivity, applicationContext)

        presenter.loadRecord()

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
                        goSearchResult()
                        return false
                    }
                }
                return true
            }
        })

    }

    override fun showRecord(words : ArrayList<String>) {
        searchHistoryAdapter.list = words
        searchHistoryAdapter.notifyDataSetChanged()
        for(i in 0..searchHistoryAdapter.list.size-1)
            Log.d("showRecord", searchHistoryAdapter.list.get(i))

    }

    override fun goSearchResult() {
        presenter.saveRecord(search_et.text.toString())
        startActivity<SearchResultActivity>("result" to search_et.text.toString())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        return super.onCreateOptionsMenu(menu)
    }

}
