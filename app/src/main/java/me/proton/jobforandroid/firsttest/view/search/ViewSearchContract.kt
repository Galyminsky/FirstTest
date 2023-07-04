package me.proton.jobforandroid.firsttest.view.search

import me.proton.jobforandroid.firsttest.model.SearchResult
import me.proton.jobforandroid.firsttest.view.ViewContract

internal interface ViewSearchContract : ViewContract {
    fun displaySearchResults(
        searchResults: List<SearchResult>,
        totalCount: Int
    )

    fun displayError()
    fun displayError(error: String)
    fun displayLoading(show: Boolean)
}
