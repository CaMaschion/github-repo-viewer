package com.camila.githubrepoviewer.model

import com.google.gson.annotations.SerializedName

data class GithubRepositories(

    @SerializedName("item") val item: List<GithubItem>

)

data class GithubItem(

    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("forks_count")val forks_count: Int,
    @SerializedName("stargazers_count")val stargazers_count: Int,
    @SerializedName("owner")var owner: GithubOwner
)

data class GithubOwner(

    @SerializedName("login")val login: String,
    @SerializedName("avatar_url")val avatar_url: String

)
