package com.camila.githubrepoviewer.repository

import com.camila.githubrepoviewer.service.GithubApi
import javax.inject.Inject


interface GithubRepository {
    fun getRepositories()
}

class GithubRepositoryImpl @Inject constructor(private val githubApi: GithubApi
) : GithubRepository {

    override fun getRepositories() {
        println("do something method called")
    }
}
