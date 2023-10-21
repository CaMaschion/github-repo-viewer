package com.camila.githubrepoviewer.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.camila.githubrepoviewer.model.RepositoryModel
import com.camila.githubrepoviewer.repository.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GitHubRepoViewModel @Inject constructor(
    private val repository: GithubRepository
) : ViewModel() {

    private val _repositories = MutableLiveData<List<RepositoryModel>>()

    fun loadRepositories() {
        viewModelScope.launch(Dispatchers.IO) {
            val listOfRepositoriesModel = repository.getRepositories()
            _repositories.postValue(listOfRepositoriesModel)
        }
    }

    fun returnToTopScreen(){
        //TODO
    }

    fun openRepositoryDetail(){
        //TODO
    }


}