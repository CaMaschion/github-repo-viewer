package com.camila.githubrepoviewer.service

import com.camila.githubrepoviewer.model.GithubRepositories
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {
    @GET("/search/repositories?q=language:kotlin&sort=stars")
    suspend fun getRepositories() : GithubRepositories
}