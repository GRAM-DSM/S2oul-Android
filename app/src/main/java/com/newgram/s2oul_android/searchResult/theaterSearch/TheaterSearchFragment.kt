package com.newgram.s2oul_android.searchResult.theaterSearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.newgram.s2oul_android.R

class TheaterSearchFragment : Fragment(), TheaterSearchContract.View {

    override lateinit var presenter: TheaterSearchContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_theater_search, container, false)
    }
}
