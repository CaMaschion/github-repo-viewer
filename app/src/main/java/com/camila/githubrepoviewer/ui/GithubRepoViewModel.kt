package com.camila.githubrepoviewer.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.camila.githubrepoviewer.model.GithubItem
import com.camila.githubrepoviewer.repository.GithubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class GitHubRepoViewModel @Inject constructor(private val repository: GithubRepository) : ViewModel() {

    private val repoList = MutableLiveData<List<GithubItem>>()

    fun getGitHubRepos() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val repos = repository.getRepositories()
                repoList.postValue(repos.item)
            } catch (e: Exception) {
                // Handle the exception (e.g., show an error message)
            }
        }
    }
}