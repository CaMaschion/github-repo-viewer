package com.camila.githubrepoviewer.di

import com.camila.githubrepoviewer.service.GithubApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit

class AppModule {

    @Module
    @InstallIn(ActivityComponent::class)
    object AppModule {
        @Provides
        fun providesGithubApi(
        ): GithubApi {
            return Retrofit.Builder()
                .baseUrl("http:api.github.com")
                .build()
                .create(GithubApi::class.java)
        }

    }
}