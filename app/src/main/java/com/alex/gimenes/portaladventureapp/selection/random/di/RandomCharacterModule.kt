package com.alex.gimenes.portaladventureapp.selection.random.di

import com.alex.gimenes.portaladventureapp.selection.random.domain.RandomNumberIDUseCase
import com.alex.gimenes.portaladventureapp.selection.random.domain.RandomNumberIDUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RandomCharacterModule {

    @Provides
    @Singleton
    fun provideRandomNumberIDUseCase(): RandomNumberIDUseCase {
        return RandomNumberIDUseCaseImpl()
    }
}