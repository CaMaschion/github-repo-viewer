package com.camila.githubrepoviewer.repository

import com.camila.githubrepoviewer.model.GithubRepositories
import com.camila.githubrepoviewer.service.GithubApi
import javax.inject.Inject


interface GithubRepository {
    fun getRepositories(): GithubRepositories
}

class GithubRepositoryImpl @Inject constructor(private val githubApi: GithubApi
) : GithubRepository {

    override fun getRepositories() : GithubRepositories {
        return githubApi.getRepositories(1)
    }
}
