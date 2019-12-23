package com.newgram.s2oul_android.detail.showDetail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.google.gson.Gson
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.detail.placeDetail.PlaceDetailActivity
import com.newgram.s2oul_android.entity.ShowDetail
import kotlinx.android.synthetic.main.activity_show_detail.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.json.JSONArray
import java.nio.charset.Charset

class ShowDetailActivity : AppCompatActivity(), ShowDetailContract.View {

    override lateinit var presenter: ShowDetailContract.Presenter

    lateinit var uri: String
    lateinit var theaterId: String

    var items = arrayListOf<ShowDetail>()

    var index: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)

        index = intent.getIntExtra("showId", 0)

        items = getShowInfoList()
        showShowDetail(items.get(index))
        ShowDetailPresenter(this@ShowDetailActivity)
        showDetail_place_layout.onClick {
            goPlaceDetail(theaterId)
        }

        showDetail_ticketing_btn.onClick {
            goTicketLink(uri)
        }

    }

    override fun showShowDetail(show: ShowDetail) {
        showDetail_name_tv.text = show.showName
        showDetail_date_tv.text = show.period
        showDetail_age_tv.text = show.age
        showDetail_price_tv.text = show.cost
        showDetail_place_tv.text = show.theaterName
        showDetail_time_tv.text = show.runningTime
        showDetail_bottom_place_name_tv.text = show.theaterName
        showDetail_bottom_address_tv.text = show.location
        showDetail_number_tv.text = show.phoneNumber
        Glide.with(this).load(show.showImage).into(showDetail_pic_iv)
        Log.d("showDetail", show.summaryImage)
        Glide.with(this).load(show.summaryImage).override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).into(showDetail_summary_iv)
        theaterId = show.theaterId
        uri = show.link
        Glide.with(this).load(show.theaterImage).into(showDetail_place_iv)
    }

    override fun goPlaceDetail(theaterId: String) {
        startActivity<PlaceDetailActivity>("theaterId" to index)
    }

    override fun goTicketLink(link: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        startActivity(intent)
    }

    private fun getShowInfoList(): ArrayList<ShowDetail> {
        var showList = arrayListOf<ShowDetail>()
        val gson = Gson()

        try {
            var input = assets.open("ShowDetails.json")
            var buffer = ByteArray(input!!.available())

            input.read(buffer)
            input.close()
            Charset.forName("UTF-8")
            val charset: Charset = Charsets.UTF_8
            val json = String(buffer, charset)

            var jsonArray = JSONArray(json)

            var index = 0
            while (index < jsonArray.length()) {
                val showDetail: ShowDetail = gson.fromJson(jsonArray.get(index).toString(), ShowDetail::class.java)
                showList.add(showDetail)

                index++
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return showList
    }
}
