package com.newgram.s2oul_android.detail.placeDetail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.adapter.PlaceDetailAdapater
import com.newgram.s2oul_android.detail.showDetail.ShowDetailActivity
import com.newgram.s2oul_android.entity.Show
import com.newgram.s2oul_android.entity.TheaterDetail
import kotlinx.android.synthetic.main.activity_place_detail.*
import org.jetbrains.anko.startActivity
import org.json.JSONArray
import java.nio.charset.Charset

class PlaceDetailActivity : AppCompatActivity(), PlaceDetailContract.View {

    override lateinit var presenter: PlaceDetailContract.Presenter

    var items = arrayListOf<TheaterDetail>()
    lateinit var showId: String
    val adapter = PlaceDetailAdapater(this)

    var index = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_detail)

        index = intent.getIntExtra("theaterId", 0)

        items = getTheaterInfoList()
        showPlaceDetail(items.get(index))

        presenter = PlaceDetailPresenter(this@PlaceDetailActivity)

        //presenter.loadPlace(intent.getStringExtra("theaterId"))

        adapter.itemClick = object: PlaceDetailAdapater.ItemClick {
            override fun onClick(v: View, position: Int) {
                startActivity<ShowDetailActivity>("showId" to position)
            }
        }
        adapter.addItems(items.get(index).shows)

        placeDetail_rv.adapter = adapter
        placeDetail_rv.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        adapter.notifyDataSetChanged()
    }

    override fun showPlaceDetail(theater: TheaterDetail) {
        placeDetail_name_tv.text = theater.theaterName
        placeDetail_number_tv.text = theater.phoneNumber
        placeDetail_address_tv.text = theater.location
        placeDetail_sitcount_tv.text = theater.seatNumber.toString()
        Glide.with(this).load(theater.theaterImage).into(placeDetail_pic_iv)
    }

    override fun addData(items: ArrayList<Show>) = adapter.addItems(items)

    override fun goShowDetail(showId: String) {
        startActivity<ShowDetailActivity>("showId" to showId)
    }

    private fun getTheaterInfoList(): ArrayList<TheaterDetail> {
        var showList = arrayListOf<TheaterDetail>()
        val gson = Gson()

        try {
            var input = assets.open("TheaterDetails.json")
            var buffer = ByteArray(input!!.available())

            input.read(buffer)
            input.close()
            Charset.forName("UTF-8")
            val charset: Charset = Charsets.UTF_8
            val json = String(buffer, charset)

            var jsonArray = JSONArray(json)

            var index = 0
            while (index < jsonArray.length()) {
                val theaterDetail: TheaterDetail = gson.fromJson(jsonArray.get(index).toString(), TheaterDetail::class.java)
                showList.add(theaterDetail)

                index++
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return showList
    }
}
