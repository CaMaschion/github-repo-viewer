package com.camila.githubrepoviewer.di

import com.camila.githubrepoviewer.repository.GithubRepository
import com.camila.githubrepoviewer.repository.GithubRepositoryImpl
import com.camila.githubrepoviewer.service.GithubApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesGithubApi(
    ): GithubApi {
        return Retrofit.Builder()
            .baseUrl("http://api.github.com")
            .build()
            .create(GithubApi::class.java)
    }

    @Provides
    fun providesGithubRepositoryImpl(
        githubApi: GithubApi
    ): GithubRepository {
        return GithubRepositoryImpl(githubApi)
    }
}
