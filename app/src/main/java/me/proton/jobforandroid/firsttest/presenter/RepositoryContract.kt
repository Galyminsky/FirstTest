package me.proton.jobforandroid.firsttest.presenter

import io.reactivex.Observable
import me.proton.jobforandroid.firsttest.model.SearchResponse
import me.proton.jobforandroid.firsttest.repository.RepositoryCallback

interface RepositoryContract {

    fun searchGithub(
        query: String,
        callback: RepositoryCallback
    )

    fun searchGithub(
        query: String
    ): Observable<SearchResponse>
}
