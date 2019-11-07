package com.newgram.s2oul_android.search

import android.os.Bundle
import android.view.KeyEvent
import android.view.Menu
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.adapter.SearchHistoryAdapter
import com.newgram.s2oul_android.searchResult.SearchResultActivity
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.item_search_history.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class SearchActivity : AppCompatActivity(), SearchContract.View {

    override lateinit var presenter: SearchContract.Presenter

    val searchHistoryAdapter by lazy { SearchHistoryAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        searchHistory_rv.adapter = searchHistoryAdapter
        searchHistory_rv.layoutManager = layoutManager
        searchHistory_rv.setHasFixedSize(true)

        presenter = SearchPresenter(this@SearchActivity, applicationContext)

        presenter.loadRecord()

        searchHistoryAdapter.itemClick = object: SearchHistoryAdapter.ItemClick {
            override fun onClick(v: View, position: Int) {
                startActivity<SearchResultActivity>("word" to v.searchHistory_history_tv.text)
            }
        }

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
    }

    override fun goSearchResult() {
        presenter.saveRecord(search_et.text.toString())
        startActivity<SearchResultActivity>("word" to search_et.text.toString())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        return super.onCreateOptionsMenu(menu)
    }

}
