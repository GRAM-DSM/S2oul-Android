package com.newgram.s2oul_android.info

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.info.placeInfo.PlaceInfoFragment
import com.newgram.s2oul_android.info.showInfo.ShowInfoFragment
import kotlinx.android.synthetic.main.fragment_info.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class InfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        info_filter_btn.onClick {
            val intent = Intent(context, InfoFilterActivity::class.java)
            startActivityForResult(intent, 2)
        }

        fragmentManager!!.beginTransaction().run {
            replace(
                R.id.info_frame, ShowInfoFragment()
            ).commit()
        }

        info_radio_group.setOnCheckedChangeListener(radioCheckChangeListener)
    }

    private val radioCheckChangeListener = RadioGroup.OnCheckedChangeListener { item, i ->
        val transaction = fragmentManager?.beginTransaction()
        when(item.checkedRadioButtonId) {
            R.id.info_show_radio -> {
                transaction!!.replace(R.id.info_frame, ShowInfoFragment())
                transaction.commit()
                return@OnCheckedChangeListener
            }
            R.id.info_place_radio -> {
                transaction!!.replace(R.id.info_frame, PlaceInfoFragment())
                transaction.commit()
                return@OnCheckedChangeListener
            }
        }
        false

    }

}
