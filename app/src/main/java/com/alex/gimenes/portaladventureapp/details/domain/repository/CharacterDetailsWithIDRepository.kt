package com.alex.gimenes.portaladventureapp.details.domain.repository

import com.alex.gimenes.portaladventureapp.common.state.State
import com.alex.gimenes.portaladventureapp.details.domain.model.CharacterDetails

interface CharacterDetailsWithIDRepository {

    suspend fun getCharacterWithID(characterID: Int) : State<CharacterDetails>

}