package com.camila.githubrepoviewer.repository

import com.camila.githubrepoviewer.model.GithubRepositories
import com.camila.githubrepoviewer.service.GithubApi
import javax.inject.Inject

interface GithubRepository {
    suspend fun getRepositories(): GithubRepositories
}

class GithubRepositoryImpl @Inject constructor(private val githubApi: GithubApi
) : GithubRepository {

    override suspend fun getRepositories() : GithubRepositories {
        return githubApi.getRepositories(1)
    }
}
