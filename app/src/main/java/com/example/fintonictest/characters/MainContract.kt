package com.example.fintonictest.characters

import com.example.fintonictest.base.BasePresenterInt
import com.example.fintonictest.base.BaseViewInt
import com.example.fintonictest.domain.client.model.Superhero

interface MainContract {
    interface View : BaseViewInt {
        fun setData2Adapter(response: List<Superhero>)
    }

    interface Presenter : BasePresenterInt<View> {
        fun getCharacters()
    }
}