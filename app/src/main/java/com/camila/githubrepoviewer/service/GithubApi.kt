package com.camila.githubrepoviewer.service

import retrofit2.http.GET

interface GithubApi {
    @GET("/search/repositories?q=language:kotlin&sort=stars")
    suspend fun searchRepositoriesByLanguage() : GitHubResponse
}