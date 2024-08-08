package com.alex.gimenes.portaladventureapp.details.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex.gimenes.portaladventureapp.common.state.State
import com.alex.gimenes.portaladventureapp.details.domain.model.CharacterDetails
import com.alex.gimenes.portaladventureapp.details.domain.repository.CharacterDetailsWithIDRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    private val characterDetailsWithIDRepository: CharacterDetailsWithIDRepository
) : ViewModel() {

    private val _validationEvent = MutableLiveData<State<CharacterDetails>>(State.Inactive)
    val validationEvent: LiveData<State<CharacterDetails>> = _validationEvent

    fun getCharacterWithID(characterID: Int) {
        viewModelScope.launch {
            _validationEvent.postValue(State.Loading(true))
            _validationEvent.postValue(
                characterDetailsWithIDRepository.getCharacterWithID(
                    characterID
                )
            )
        }
    }
}