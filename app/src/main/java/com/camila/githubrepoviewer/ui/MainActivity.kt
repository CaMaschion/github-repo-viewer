package com.camila.githubrepoviewer.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.camila.githubrepoviewer.R
import com.camila.githubrepoviewer.repository.GithubRepository
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: GitHubRepoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val repositories = viewModel.getGitHubRepos()

    }
}