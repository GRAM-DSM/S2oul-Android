package com.newgram.s2oul_android.detail.showDetail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.detail.placeDetail.PlaceDetailActivity
import com.newgram.s2oul_android.entity.ShowDetail
import kotlinx.android.synthetic.main.activity_show_detail.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class ShowDetailActivity : AppCompatActivity(), ShowDetailContract.View {

    override lateinit var presenter: ShowDetailContract.Presenter

    lateinit var uri: String
    lateinit var theaterId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)

        ShowDetailPresenter(this@ShowDetailActivity)
        presenter.loadShow(intent.getStringExtra("showId"))

        intent.getStringExtra("name")
        showDetail_place_layout.onClick {
            goPlaceDetail(theaterId)
        }

        showDetail_ticketing_btn.onClick {
            goTicketLink(uri)
        }

    }

    override fun showShowDetail(show: ShowDetail) {
        showDetail_name_tv.text = intent.getStringExtra("name")
        showDetail_date_tv.text = show.period
        showDetail_age_tv.text = show.age
        showDetail_price_tv.text = show.cost
        showDetail_place_tv.text = show.theaterName
        showDetail_time_tv.text = show.runningTime
        showDetail_bottom_place_name_tv.text = show.theaterName
        showDetail_bottom_address_tv.text = show.location
        showDetail_number_tv.text = show.phoneNumber
        theaterId = show.theaterId
        uri = show.link
        Glide.with(this).load(show.theaterImage).into(showDetail_place_iv)
    }

    override fun goPlaceDetail(theaterId: String) {
        startActivity<PlaceDetailActivity>("theaterId" to theaterId)
    }

    override fun goTicketLink(link: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://${uri}"))
        startActivity(intent)
    }
}
