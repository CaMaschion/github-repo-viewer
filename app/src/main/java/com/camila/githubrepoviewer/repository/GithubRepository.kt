package com.camila.githubrepoviewer.repository

import com.camila.githubrepoviewer.model.RepositoryDetailModel
import com.camila.githubrepoviewer.model.RepositoryModel
import com.camila.githubrepoviewer.service.GitHubRepositoryResponse
import com.camila.githubrepoviewer.service.GithubApi
import javax.inject.Inject

interface GithubRepository {
    suspend fun getRepositories(): List<RepositoryModel>
}

class GithubRepositoryImpl @Inject constructor(
    private val service: GithubApi
) : GithubRepository {

    override suspend fun getRepositories(): List<RepositoryModel> {
        try {
            val resultListOfModel = arrayListOf<RepositoryModel>()
            val apiResult = service.searchRepositoriesByLanguage()
            apiResult.repositoryResponse.forEach {
                val model = transformResponseToModel(it)
                resultListOfModel.add(model)
            }
            return resultListOfModel
        } catch (exception: Exception) {
            throw exception
        }
    }

    private fun transformResponseToModel(repository: GitHubRepositoryResponse): RepositoryModel {
        val model = RepositoryModel()
        model.repositoryName = repository.name
        model.repositoryDetail = RepositoryDetailModel(
            login = repository.owner.login,
            avatarUrl = repository.owner.avatarUrl,
            forks = repository.forksCount,
            stars = repository.stargazersCount,
            description = repository.description
        )
        return model
    }
}
