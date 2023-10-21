package com.camila.githubrepoviewer.service

import com.google.gson.annotations.SerializedName

data class GitHubResponse(
    @SerializedName("items") val repositoryResponse: List<GitHubRepositoryResponse>
)

data class GitHubRepositoryResponse(

    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("forks_count")val forksCount: Int,
    @SerializedName("stargazers_count")val stargazersCount: Int,
    @SerializedName("owner")var owner: GitHubDetailResponse
)

data class GitHubDetailResponse(

    @SerializedName("login")val login: String,
    @SerializedName("avatar_url")val avatarUrl: String

)
