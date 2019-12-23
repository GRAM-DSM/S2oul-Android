package com.newgram.s2oul_android.info.placeInfo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.adapter.PlaceInfoAdapter
import com.newgram.s2oul_android.detail.placeDetail.PlaceDetailActivity
import com.newgram.s2oul_android.entity.TheaterInfo
import kotlinx.android.synthetic.main.fragment_place_info.*
import org.json.JSONArray
import java.nio.charset.Charset


class PlaceInfoFragment : Fragment(), PlaceInfoContract.View {

    override lateinit var presenter: PlaceInfoContract.Presenter
    val adapter = PlaceInfoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = PlaceInfoPresenter(this)
        //presenter.loadPlace()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.items = getPlaceInfoList()
        info_place_rv.adapter = adapter
        info_place_rv.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)

        adapter.itemClick = object: PlaceInfoAdapter.ItemClick {
            override fun onClick(v: View, position: Int) {
                val intent = Intent(context, PlaceDetailActivity::class.java)
                intent.putExtra("theaterId", position)
                intent.putExtra("theaterName", v.findViewById<TextView>(R.id.info_place_placeName_tv).text as String?)
                startActivity(intent)
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_place_info, container, false)
    }

    override fun showPlaces(items: ArrayList<TheaterInfo>) {
        adapter.items = items
    }

    private fun getPlaceInfoList(): ArrayList<TheaterInfo> {
        var showList = arrayListOf<TheaterInfo>()
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
                val theaterInfo: TheaterInfo = gson.fromJson(jsonArray.get(index).toString(), TheaterInfo::class.java)
                showList.add(theaterInfo)

                index++
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return showList
    }
}
