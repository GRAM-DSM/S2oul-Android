package com.newgram.s2oul_android.searchResult.theaterSearch

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.adapter.TheaterSearchAdapter
import com.newgram.s2oul_android.detail.placeDetail.PlaceDetailActivity
import com.newgram.s2oul_android.entity.TheaterResult
import kotlinx.android.synthetic.main.fragment_theater_search.*
import org.jetbrains.anko.support.v4.startActivity
import org.json.JSONArray
import java.nio.charset.Charset

class TheaterSearchFragment : Fragment(), TheaterSearchContract.View {

    override lateinit var presenter: TheaterSearchContract.Presenter

    var items = ArrayList<TheaterResult>()
    var resultItem = ArrayList<TheaterResult>()
    var word: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = TheaterSearchPresenter(this@TheaterSearchFragment)

//        presenter.loadResult(activity.let {
//            it!!.intent.getStringExtra("word")
//        }
//        )
    }

    override fun goTheaterDetail(theateId: String) {
        startActivity<PlaceDetailActivity>("theaterId" to "theaterId")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        word = activity.let {
            it!!.intent.getStringExtra("word")
        }
        return inflater.inflate(R.layout.fragment_theater_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = TheaterSearchAdapter()
        searchDetail_place_rv.adapter = adapter
        searchDetail_place_rv.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)

        items = getPlaceInfoList()

        for(i in 0..items.size-1) {
            if (items.get(i).theaterName == word) {
                resultItem.add(items.get(i))
            }
        }

        adapter.items = resultItem

        adapter.itemClick = object: TheaterSearchAdapter.ItemClick {
            override fun onClick(v: View, position: Int) {
                val intent = Intent(context, PlaceDetailActivity::class.java)
                intent.putExtra("theaterId", position)
                startActivity(intent)
            }
        }
    }

    override fun showResult(list: ArrayList<TheaterResult>) {
        //adapter.items = list
    }

    private fun getPlaceInfoList(): ArrayList<TheaterResult> {
        var showList = arrayListOf<TheaterResult>()
        val gson = Gson()

        try {
            var input = context!!.assets.open("Theater.json")
            var buffer = ByteArray(input!!.available())

            input.read(buffer)
            input.close()
            Charset.forName("UTF-8")
            val charset: Charset = Charsets.UTF_8
            val json = String(buffer, charset)

            var jsonArray = JSONArray(json)

            var index = 0
            while (index < jsonArray.length()) {
                val theaterResult: TheaterResult = gson.fromJson(jsonArray.get(index).toString(), TheaterResult::class.java)
                showList.add(theaterResult)

                index++
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return showList
    }
}
