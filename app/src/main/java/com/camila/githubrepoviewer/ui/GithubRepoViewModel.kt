package com.camila.githubrepoviewer.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.camila.githubrepoviewer.repository.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GitHubRepoViewModel @Inject constructor(
    private val githubRepo: GithubRepository
): ViewModel() {

   fun getRepositoriesFromGithub()
    {
        viewModelScope.launch(Dispatchers.IO) {
            githubRepo.getRepositories()
        }
    }

}