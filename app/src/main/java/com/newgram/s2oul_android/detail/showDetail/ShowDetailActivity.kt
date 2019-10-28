package com.newgram.s2oul_android.detail.showDetail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.detail.placeDetail.PlaceDetailActivity
import kotlinx.android.synthetic.main.activity_show_detail.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class ShowDetailActivity : AppCompatActivity(), ShowDetailContract.View {

    override lateinit var presenter: ShowDetailContract.Presenter

    lateinit var uri: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)

        ShowDetailPresenter(this@ShowDetailActivity)
        showShowDetail()

        intent.getStringExtra("name")
        showDetail_place_layout.onClick {
            goPlaceDetail("theaterId")
        }

        showDetail_ticketing_btn.onClick {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://${uri}"))
            startActivity(intent)
        }

    }

    override fun showShowDetail() {
        showDetail_name_tv.text = intent.getStringExtra("name")
        showDetail_date_tv.text
        showDetail_age_tv.text
        showDetail_price_tv.text
        showDetail_place_tv.text
        showDetail_time_tv.text
    }

    override fun showThisTheater() {
        showDetail_bottom_place_name_tv.text
        showDetail_bottom_address_tv.text
        showDetail_number_tv.text
        showDetail_place_iv
    }

    override fun goPlaceDetail(theaterId: String) {
        startActivity<PlaceDetailActivity>("theaterId" to theaterId)
    }
}
