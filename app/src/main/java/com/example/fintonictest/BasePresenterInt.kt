package com.example.fintonictest

interface BasePresenterInt<T> {
    fun bind(view: T)
    fun unBind()
}