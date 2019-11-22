package com.example.fintonictest

import androidx.lifecycle.LiveData

interface MainContract {
    interface View : BaseViewInt {
        fun setData2Adapter(response: List<Superhero>)
    }

    interface Presenter : BasePresenterInt<View> {
        fun getCharacters()
    }
}