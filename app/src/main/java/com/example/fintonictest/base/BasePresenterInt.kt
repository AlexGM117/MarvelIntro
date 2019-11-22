package com.example.fintonictest.base

interface BasePresenterInt<T> {
    fun bind(view: T)
    fun unBind()
}