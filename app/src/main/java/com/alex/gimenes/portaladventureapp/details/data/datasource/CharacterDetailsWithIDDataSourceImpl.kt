package com.alex.gimenes.portaladventureapp.details.data.datasource

import com.alex.gimenes.portaladventureapp.details.data.api.SearchCharacterWithIDApi
import com.alex.gimenes.portaladventureapp.details.domain.model.CharacterDetails

class CharacterDetailsWithIDDataSourceImpl(
    private val characterWithIDApi: SearchCharacterWithIDApi
) : CharacterDetailsWithIDDataSource {
    override suspend fun getCharacterDetailsWithID(characterID: Int): CharacterDetails {
        return characterWithIDApi.getCharacter(characterID.toString())
    }
}