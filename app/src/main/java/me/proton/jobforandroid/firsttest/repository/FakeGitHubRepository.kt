package me.proton.jobforandroid.firsttest.repository

import me.proton.jobforandroid.firsttest.model.SearchResponse
import me.proton.jobforandroid.firsttest.presenter.RepositoryContract
import retrofit2.Response

internal class FakeGitHubRepository : RepositoryContract {

    override fun searchGithub(
        query: String,
        callback: RepositoryCallback
    ) {
        callback.handleGitHubResponse(Response.success(SearchResponse(42, listOf())))
    }
}
