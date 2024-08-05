package com.alex.gimenes.portaladventureapp.details.di

import com.alex.gimenes.portaladventureapp.details.data.api.SearchCharacterWithIDApi
import com.alex.gimenes.portaladventureapp.details.data.datasource.CharacterDetailsWithIDDataSource
import com.alex.gimenes.portaladventureapp.details.data.datasource.CharacterDetailsWithIDDataSourceImpl
import com.alex.gimenes.portaladventureapp.details.data.repository.CharacterDetailsWithIDRepositoryImpl
import com.alex.gimenes.portaladventureapp.details.domain.repository.CharacterDetailsWithIDRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DetailsModule {
    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    @Provides
    @Singleton
    fun providesCharacterDetailsWithIDDataSource(myApi: SearchCharacterWithIDApi) : CharacterDetailsWithIDDataSource {
        return CharacterDetailsWithIDDataSourceImpl(myApi)
    }

    @Provides
    @Singleton
    fun providesCharacterDetailsWithIDRepository(dataSource: CharacterDetailsWithIDDataSource) : CharacterDetailsWithIDRepository {
        return CharacterDetailsWithIDRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    @Singleton
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient) : Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit): SearchCharacterWithIDApi = retrofit.create(
        SearchCharacterWithIDApi::class.java)
}