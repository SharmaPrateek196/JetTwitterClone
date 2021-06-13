package com.example.androiddevchallenge.di

import android.content.Context
import com.example.androiddevchallenge.TwitterApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.components.*
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideApplication(
        @ApplicationContext app: Context
    ) :  TwitterApplication {
        return app as TwitterApplication
    }
}