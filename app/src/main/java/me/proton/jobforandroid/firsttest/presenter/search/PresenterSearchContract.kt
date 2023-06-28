package me.proton.jobforandroid.firsttest.presenter.search

import me.proton.jobforandroid.firsttest.presenter.PresenterContract

internal interface PresenterSearchContract : PresenterContract {
    fun searchGitHub(searchQuery: String)
}
