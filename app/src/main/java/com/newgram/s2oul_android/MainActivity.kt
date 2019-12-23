package com.newgram.s2oul_android

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.newgram.s2oul_android.info.InfoFragment
import com.newgram.s2oul_android.map.MapFragment
import com.newgram.s2oul_android.recommend.RecommendFragment
import com.newgram.s2oul_android.search.SearchActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    var fragmentManager = supportFragmentManager

    private var backPressedTime : Long = 0

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

    override fun onBackPressed() {
        //super.onBackPressed()

        if (System.currentTimeMillis() > backPressedTime + 2000) {
            backPressedTime = System.currentTimeMillis()
            Toast.makeText(this, "뒤로 버튼을 한번 더 누르면 종료됩니다", Toast.LENGTH_SHORT).show()
            return
        }
        if (System.currentTimeMillis() <= backPressedTime + 2000) {
            super.onBackPressed()
        }
    }
}
