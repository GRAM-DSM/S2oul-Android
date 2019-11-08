package com.newgram.s2oul_android.info.showInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.adapter.ShowInfoAdapter
import com.newgram.s2oul_android.entity.ShowInfo
import kotlinx.android.synthetic.main.fragment_show_info.*

class ShowInfoFragment : Fragment(), ShowInfoContract.View {

    override lateinit var presenter: ShowInfoContract.Presenter
    lateinit var adapter: ShowInfoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = ShowInfoPresenter(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ShowInfoAdapter()
        info_show_rv.adapter = adapter
        info_show_rv.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_info, container, false)
    }

    override fun showContents(shows: ArrayList<ShowInfo>) {
        adapter.items = shows
    }
}
