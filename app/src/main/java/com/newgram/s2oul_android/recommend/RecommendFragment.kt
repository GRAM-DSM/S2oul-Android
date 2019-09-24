package com.newgram.s2oul_android.recommend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.newgram.s2oul_android.R
import com.ramotion.cardslider.CardSliderLayoutManager
import kotlinx.android.synthetic.main.fragment_recommend.*

class RecommendFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recommend, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recommend_rv.apply {
            //adapter =
            layoutManager = CardSliderLayoutManager(context)
        }
    }

}