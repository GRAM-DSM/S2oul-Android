package com.newgram.s2oul_android.searchResult.showSearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.adapter.ShowSearchAdapter
import com.newgram.s2oul_android.detail.showDetail.ShowDetailActivity
import com.newgram.s2oul_android.entity.ShowResult
import kotlinx.android.synthetic.main.fragment_show_search.*
import org.jetbrains.anko.support.v4.startActivity

class ShowSearchFragment : Fragment(), ShowSearchContract.View {

    override lateinit var presenter: ShowSearchContract.Presenter

    var items = ArrayList<ShowResult>()
    val adapter = ShowSearchAdapter(this.context!!)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = ShowSearchPresenter(this@ShowSearchFragment)

        presenter.loadResult(activity.let {
            it!!.intent.getStringExtra("showId")
        })

        searchDetail_show_rv.adapter = adapter
        searchDetail_show_rv.layoutManager = LinearLayoutManager(this.context!!, RecyclerView.VERTICAL, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_search, container, false)
    }

    override fun showResult(list: ArrayList<ShowResult>) {
        adapter.items = list
    }

    override fun goDetail(id: String) {
        startActivity<ShowDetailActivity>("showId" to "showId")
    }
}
