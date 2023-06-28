package me.proton.jobforandroid.firsttest.repository

import me.proton.jobforandroid.firsttest.model.SearchResponse
import retrofit2.Response

interface RepositoryCallback {
    fun handleGitHubResponse(response: Response<SearchResponse?>?)
    fun handleGitHubError()
}
