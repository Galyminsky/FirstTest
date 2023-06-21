package me.proton.jobforandroid.firsttest.presenter

import me.proton.jobforandroid.firsttest.repository.RepositoryCallback

internal interface RepositoryContract {
    fun searchGithub(
        query: String,
        callback: RepositoryCallback
    )
}
