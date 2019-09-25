package com.newgram.s2oul_android.placeDetail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

        adapter.itemClick = object: PlaceDetailAdapater.ItemClick {
            override fun onClick(v: View, position: Int) {
                startActivity<ShowDetailActivity>("name" to "")
            }
        }
        placeDetail_rv.adapter = adapter
        placeDetail_rv.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
    }
}
