package com.newgram.s2oul_android.placeDetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.entities.Showing
import com.newgram.s2oul_android.showDetail.ShowDetailActivity
import kotlinx.android.synthetic.main.activity_place_detail.*
import org.jetbrains.anko.startActivity

class PlaceDetailActivity : AppCompatActivity() {

    var items = ArrayList<Showing>()
    val adapter = PlaceDetailAdapater(this, items)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_detail)

        placeDetail_name_tv.text = intent.getStringExtra("name")
        placeDetail_number_tv.text
        placeDetail_address_tv.text
        placeDetail_sitcount_tv.text

        placeDetail_rv.adapter = adapter
    }

    fun goShowDetail(name: String) {
        startActivity<ShowDetailActivity>("name" to name)
    }
}
