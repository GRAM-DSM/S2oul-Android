package com.newgram.s2oul_android.searchResult.showSearch

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.adapter.ShowSearchAdapter
import com.newgram.s2oul_android.detail.showDetail.ShowDetailActivity
import com.newgram.s2oul_android.entity.ShowInfo
import com.newgram.s2oul_android.entity.ShowResult
import kotlinx.android.synthetic.main.fragment_show_search.*
import org.jetbrains.anko.support.v4.startActivity
import org.json.JSONArray
import java.nio.charset.Charset

class ShowSearchFragment : Fragment(), ShowSearchContract.View {

    override lateinit var presenter: ShowSearchContract.Presenter

    var items = ArrayList<ShowInfo>()
    var resultItem = ArrayList<ShowInfo>()
    var word: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = ShowSearchPresenter(this@ShowSearchFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("showSearhc", activity.let {
            it!!.intent.getStringExtra("word")
        })
        word = activity.let {
            it!!.intent.getStringExtra("word")
        }
        return inflater.inflate(R.layout.fragment_show_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ShowSearchAdapter()
        items = getShowInfoList()
        Log.d("showsearch", items.toString())
        searchDetail_show_rv.adapter = adapter
        searchDetail_show_rv.layoutManager = LinearLayoutManager(this.context!!, RecyclerView.VERTICAL, false)

        for(i in 0..items.size-1) {
            if (items.get(i).showName == word) {
                resultItem.add(items.get(i))
            }
        }

        adapter.items = resultItem

        adapter.itemClick = object: ShowSearchAdapter.ItemClick {
            override fun onClick(v: View, position: Int) {
                val intent = Intent(context, ShowDetailActivity::class.java)
                intent.putExtra("showId", position)
                startActivity(intent)
            }
        }
    }

    override fun showResult(list: ArrayList<ShowResult>) {
        //adapter.items = list
    }

    override fun goDetail(id: String) {
        startActivity<ShowDetailActivity>("showId" to "showId")
    }

    private fun getShowInfoList(): ArrayList<ShowInfo> {
        var showList = arrayListOf<ShowInfo>()
        val gson = Gson()

        try {
            var input = context!!.assets.open("Show.json")
            var buffer = ByteArray(input!!.available())

            input.read(buffer)
            input.close()
            Charset.forName("UTF-8")
            val charset: Charset = Charsets.UTF_8
            val json = String(buffer, charset)

            var jsonArray = JSONArray(json)

            var index = 0
            while (index < jsonArray.length()) {
                val showInfo: ShowInfo = gson.fromJson(jsonArray.get(index).toString(), ShowInfo::class.java)
                showList.add(showInfo)

                index++
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return showList
    }
}
