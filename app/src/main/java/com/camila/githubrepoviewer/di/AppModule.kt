package com.camila.githubrepoviewer.di

import com.camila.githubrepoviewer.repository.GithubRepository
import com.camila.githubrepoviewer.repository.GithubRepositoryImpl
import com.camila.githubrepoviewer.service.GithubApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesGithubApi(
    ): GithubApi {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
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
