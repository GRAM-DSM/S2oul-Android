package com.newgram.s2oul_android.searchFilter

import com.newgram.s2oul_android.BasePresenter
import com.newgram.s2oul_android.BaseView

interface SearchFilterContract {
    interface View: BaseView<Presenter> {
        fun acceptFilter()
    }

    interface Presenter: BasePresenter {
    }
}