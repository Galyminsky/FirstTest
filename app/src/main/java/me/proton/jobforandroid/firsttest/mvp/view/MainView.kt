package me.proton.jobforandroid.firsttest.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface MainView: MvpView {
    fun viewOk()
    fun viewEmailsNotEqual()
    fun viewInvalidEmail()
    fun viewInvalidName()
}

