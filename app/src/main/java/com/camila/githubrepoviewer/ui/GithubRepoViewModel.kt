package com.camila.githubrepoviewer.ui

import androidx.lifecycle.ViewModel
import com.camila.githubrepoviewer.repository.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class GitHubRepoViewModel @Inject constructor(val githubRepo: GithubRepository
): ViewModel() {

    suspend fun getRepositoriesFromGithub()
    {
        githubRepo.getRepositories()
        println("Hello")
    }
}