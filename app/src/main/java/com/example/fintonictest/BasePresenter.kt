package com.example.fintonictest

abstract class BasePresenter<T: BaseViewInt> : BasePresenterInt<T> {

    protected var view: T? = null
    protected var baseView: BaseViewInt? = null

    override fun bind(view: T) {
        this.view = view
        this.baseView = view
    }

    override fun unBind() {
        view = null
        baseView = null
    }
}