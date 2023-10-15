package com.camila.githubrepoviewer.model

data class GithubRepositories(

    val item: List<GithubItem>

)

data class GithubItem(

    val name: String,
    val description: String,
    val forks_count: Int,
    val stargazers_count: Int,
    var owner: GithubOwner
)

data class GithubOwner(

    val login: String,
    val avatar_url: String

)
