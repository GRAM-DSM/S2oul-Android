package com.newgram.s2oul_android

import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.newgram.s2oul_android.detail.placeDetail.PlaceDetailActivity
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class PlaceDetailActivityTest {

    @Rule
    @JvmField
    var androidRule = ActivityTestRule(PlaceDetailActivity::class.java)
}