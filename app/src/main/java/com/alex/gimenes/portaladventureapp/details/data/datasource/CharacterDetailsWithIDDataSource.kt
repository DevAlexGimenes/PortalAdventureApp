package com.alex.gimenes.portaladventureapp.details.data.datasource

import com.alex.gimenes.portaladventureapp.details.domain.model.CharacterDetails

interface CharacterDetailsWithIDDataSource {

    suspend fun getCharacterDetailsWithID(characterID: Int) : CharacterDetails
}