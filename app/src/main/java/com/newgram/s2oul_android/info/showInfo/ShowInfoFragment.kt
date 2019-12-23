package com.newgram.s2oul_android.info.showInfo

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
import com.newgram.s2oul_android.adapter.ShowInfoAdapter
import com.newgram.s2oul_android.detail.showDetail.ShowDetailActivity
import com.newgram.s2oul_android.entity.ShowInfo
import kotlinx.android.synthetic.main.fragment_show_info.*
import org.json.JSONArray
import java.nio.charset.Charset

class ShowInfoFragment : Fragment(), ShowInfoContract.View {

    override lateinit var presenter: ShowInfoContract.Presenter
    lateinit var adapter: ShowInfoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = ShowInfoPresenter(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getShowInfoList()
        val adapter = ShowInfoAdapter()
        adapter.items = getShowInfoList()
        info_show_rv.adapter = adapter
        info_show_rv.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)

        adapter.itemClick = object: ShowInfoAdapter.ItemClick {
            override fun onClick(v: View, position: Int) {
                val intent = Intent(context, ShowDetailActivity::class.java)
                intent.putExtra("showId", position)
                intent.putExtra("showName", v.findViewById<TextView>(R.id.info_show_showName_tv).text as String?)
                startActivity(intent)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_info, container, false)
    }

    override fun showContents(shows: ArrayList<ShowInfo>) {
        adapter.items = shows
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
