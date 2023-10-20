package com.camila.githubrepoviewer.repository

import com.camila.githubrepoviewer.model.GithubItem
import com.camila.githubrepoviewer.service.GithubApi
import javax.inject.Inject

interface GithubRepository {
    suspend fun getRepositories(): List<GithubItem>
}

class GithubRepositoryImpl @Inject constructor(private val service: GithubApi
) : GithubRepository {

    override suspend fun getRepositories() : List<GithubItem> {
        return try {
            val apiResult = service.getRepositories()
            apiResult.items
        } catch (exception: Exception) {
            throw exception
        }
    }
}
