package com.alex.gimenes.portaladventureapp.details.data.repository

import com.alex.gimenes.portaladventureapp.common.state.State
import com.alex.gimenes.portaladventureapp.details.data.datasource.CharacterDetailsWithIDDataSource
import com.alex.gimenes.portaladventureapp.details.domain.model.CharacterDetails
import com.alex.gimenes.portaladventureapp.details.domain.repository.CharacterDetailsWithIDRepository

class CharacterDetailsWithIDRepositoryImpl(
    private val characterDetailsWithIDDataSource: CharacterDetailsWithIDDataSource
) : CharacterDetailsWithIDRepository {

    override suspend fun getCharacterWithID(characterID: Int): State<CharacterDetails> {
        return try {
            val response = characterDetailsWithIDDataSource.getCharacterDetailsWithID(characterID)
            State.Success(response)
        } catch (e: Exception) {
            State.Error(e)
        }
    }
}