package com.camila.githubrepoviewer.model

class RepositoryModel {
     lateinit var repositoryName: String
     lateinit var repositoryDetail: RepositoryDetailModel

}

data class RepositoryDetailModel(
    val login: String,
    val description: String,
    val avatarUrl: String,
    val forks: Int,
    val stars: Int
)
