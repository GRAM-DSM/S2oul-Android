package com.newgram.s2oul_android.placeInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.adapter.PlaceInfoAdapter
import com.newgram.s2oul_android.entity.TheaterInfo
import kotlinx.android.synthetic.main.fragment_place_info.*


class PlaceInfoFragment : Fragment(), PlaceInfoContract.View {

    override lateinit var presenter: PlaceInfoContract.Presenter
    val adapter = PlaceInfoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = PlaceInfoPresenter(this)
        presenter.loadPlace()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        info_place_rv.adapter = adapter
        info_place_rv.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)

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
}
