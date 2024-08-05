package com.alex.gimenes.portaladventureapp.details.data.api

import com.alex.gimenes.portaladventureapp.details.domain.model.CharacterDetails
import retrofit2.http.GET
import retrofit2.http.Path

interface SearchCharacterWithIDApi {
    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: String) : CharacterDetails
}