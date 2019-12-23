package com.newgram.s2oul_android.recommend

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.adapter.RecommendAdapter
import com.newgram.s2oul_android.entity.TheaterInfo
import com.ramotion.cardslider.CardSliderLayoutManager
import com.ramotion.cardslider.CardSnapHelper
import kotlinx.android.synthetic.main.fragment_recommend.*
import org.jetbrains.anko.support.v4.find
import org.json.JSONArray
import java.net.URL
import java.nio.charset.Charset

class RecommendFragment : Fragment() {

    private val pics = arrayOf(R.drawable.ic_theater1, R.drawable.ic_theater2, R.drawable.ic_theater3, R.drawable.ic_theater4, R.drawable.ic_theater5)
    lateinit var recommendAdapter: RecommendAdapter

    private lateinit var layoutManager: CardSliderLayoutManager
    private var currentPosition: Int? = null
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recommend, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recommendAdapter = RecommendAdapter(context!!, pics)
        initRecycleView()
        recommend_rv.apply {
            adapter = recommendAdapter
            layoutManager = CardSliderLayoutManager(300, 500, 6f)
        }
        CardSnapHelper().attachToRecyclerView(recommend_rv)
    }

    private fun initRecycleView() {
        recyclerView = find(R.id.recommend_rv)
        recyclerView.adapter = recommendAdapter
        recyclerView.setHasFixedSize(true)

        recyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    onActiveCardChange()
                }
            }
        })

        layoutManager = recyclerView.layoutManager as CardSliderLayoutManager
    }

    fun onActiveCardChange() {
        val pos: Int = layoutManager.activeCardPosition
        if (pos == RecyclerView.NO_POSITION || pos == currentPosition) {
            return
        }
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

    private fun drawableFromUrl(url: String): Drawable {
        var x: Bitmap
        var connection = URL(url).openConnection()
        connection.connect()
        val input = connection.getInputStream()

        x = BitmapFactory.decodeStream(input)
        return BitmapDrawable(resources, x)

    }

}