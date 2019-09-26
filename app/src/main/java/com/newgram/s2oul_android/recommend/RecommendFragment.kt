package com.newgram.s2oul_android.recommend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.newgram.s2oul_android.R
import com.ramotion.cardslider.CardSliderLayoutManager
import com.ramotion.cardslider.CardSnapHelper
import kotlinx.android.synthetic.main.fragment_recommend.*
import org.jetbrains.anko.support.v4.find

class RecommendFragment : Fragment() {

    private val pics = arrayOf(R.drawable.ic_button, R.drawable.ic_cancel, R.drawable.ic_history)
    lateinit var recommendAdapter: RecommendAdapter

    private lateinit var layoutManager: CardSliderLayoutManager
    private var currentPosition: Int? = null
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recommend, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recommendAdapter = RecommendAdapter(context!!, pics)
        initRecycleView()
        recommend_rv.apply {
            adapter = recommendAdapter
            layoutManager = CardSliderLayoutManager(context)
        }
        CardSnapHelper().attachToRecyclerView(recommend_rv)
    }

    private fun initRecycleView() {
        recyclerView = find(R.id.recommend_rv)
        recyclerView.adapter = recommendAdapter
        recyclerView.setHasFixedSize(true)

        recyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    onActiveCardChange()
                }
            }
        })

        layoutManager = recyclerView.layoutManager as CardSliderLayoutManager
    }

    fun onActiveCardChange() {
        val pos: Int = layoutManager.activeCardPosition
        if (pos == RecyclerView.NO_POSITION || pos == currentPosition) {
            return
        }
    }

}