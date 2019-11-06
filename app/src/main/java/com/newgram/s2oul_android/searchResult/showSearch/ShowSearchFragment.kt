package com.newgram.s2oul_android.searchResult.showSearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.newgram.s2oul_android.R

class ShowSearchFragment : Fragment(), ShowSearchContract.View {

    override lateinit var presenter: ShowSearchContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_search, container, false)
    }

    override fun showResult() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goDetail(id: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
