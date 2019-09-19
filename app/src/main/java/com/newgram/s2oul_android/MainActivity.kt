package com.newgram.s2oul_android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    var fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_goSearch_iv.onClick { startActivity<SearchActivity>()}

        supportFragmentManager.beginTransaction().run {
            replace(R.id.main_frame, RecommendFragment())
            commit()
        }
        main_menu.setOnNavigationItemSelectedListener(navigationItemSelectedListner)
    }

    private val navigationItemSelectedListner = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val transaction = supportFragmentManager.beginTransaction()
        when (item.itemId) {
            R.id.navigation_main -> {
                transaction.replace(R.id.main_frame, RecommendFragment())
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_info -> {
                transaction.replace(R.id.main_frame, InfoFragment())
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_map -> {
                transaction.replace(R.id.main_frame, MapFragment())
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false

    }
}
