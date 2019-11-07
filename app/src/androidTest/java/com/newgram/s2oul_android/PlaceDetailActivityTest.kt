package com.newgram.s2oul_android

import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.newgram.s2oul_android.detail.placeDetail.PlaceDetailActivity
import com.newgram.s2oul_android.entity.Show
import com.newgram.s2oul_android.entity.TheaterDetail
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class PlaceDetailActivityTest {

    @Rule
    @JvmField
    var androidRule = ActivityTestRule(PlaceDetailActivity::class.java)

    var theater =
        TheaterDetail(
        "null",
        "서울극장",
        "01055553333",
            "서울 마포구 근처",
            "123",
            arrayOf(Show("", "name", "144"), Show("", "이름", "155"), Show("", "엉", "166")) )

    fun getTheater() {
    }
}