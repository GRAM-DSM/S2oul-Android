package com.newgram.s2oul_android.detail.placeDetail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.detail.showDetail.ShowDetailActivity
import com.newgram.s2oul_android.entity.Show
import com.newgram.s2oul_android.entity.TheaterDetail
import kotlinx.android.synthetic.main.activity_place_detail.*
import org.jetbrains.anko.startActivity

class PlaceDetailActivity : AppCompatActivity(), PlaceDetailContract.View {

    override lateinit var presenter: PlaceDetailContract.Presenter

    var items = ArrayList<Show>()
    lateinit var showId: String
    val adapter = PlaceDetailAdapater(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_detail)

        PlaceDetailPresenter(this@PlaceDetailActivity)

        presenter.loadPlace(intent.getStringExtra("theaterId"))

        adapter.itemClick = object: PlaceDetailAdapater.ItemClick {
            override fun onClick(v: View, position: Int) {
                startActivity<ShowDetailActivity>("name" to position)
            }
        }
        adapter.addItems(items)

        placeDetail_rv.adapter = adapter
        placeDetail_rv.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        adapter.notifyDataSetChanged()
    }

    override fun showPlaceDetail(theater: TheaterDetail) {
        placeDetail_name_tv.text = intent.getStringExtra("name")
        placeDetail_number_tv.text = theater.phoneNumber
        placeDetail_address_tv.text = theater.location
        placeDetail_sitcount_tv.text = theater.seatNumber
        Glide.with(this).load(theater.image).into(placeDetail_pic_iv)
    }

    override fun addData(items: ArrayList<Show>) = adapter.addItems(items)

    override fun goShowDetail(showId: String) {
        startActivity<ShowDetailActivity>("showId" to showId)
    }
}
