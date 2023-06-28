package me.proton.jobforandroid.firsttest.presenter.details

import me.proton.jobforandroid.firsttest.presenter.PresenterContract

internal interface PresenterDetailsContract : PresenterContract {
    fun setCounter(count: Int)
    fun onIncrement()
    fun onDecrement()
}
