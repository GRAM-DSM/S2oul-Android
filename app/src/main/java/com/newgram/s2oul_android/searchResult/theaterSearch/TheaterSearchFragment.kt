package com.newgram.s2oul_android.searchResult.theaterSearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.adapter.TheaterSearchAdapter
import com.newgram.s2oul_android.detail.placeDetail.PlaceDetailActivity
import com.newgram.s2oul_android.entity.TheaterResult
import kotlinx.android.synthetic.main.fragment_theater_search.*
import org.jetbrains.anko.support.v4.startActivity

class TheaterSearchFragment : Fragment(), TheaterSearchContract.View {

    override lateinit var presenter: TheaterSearchContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = TheaterSearchPresenter(this@TheaterSearchFragment)

//        presenter.loadResult(activity.let {
//            it!!.intent.getStringExtra("word")
//        }
//        )
    }

    override fun goTheaterDetail(theateId: String) {
        startActivity<PlaceDetailActivity>("theaterId" to "theaterId")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_theater_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = TheaterSearchAdapter()
        searchDetail_place_rv.adapter = adapter
        searchDetail_place_rv.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
    }

    override fun showResult(list: ArrayList<TheaterResult>) {
        //adapter.items = list
    }
}
