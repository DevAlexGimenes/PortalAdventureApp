package com.alex.gimenes.portaladventureapp.selection.random.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex.gimenes.portaladventureapp.selection.random.domain.RandomNumberIDUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomCharacterViewModel @Inject constructor(
    private val randomNumberIDUseCase: RandomNumberIDUseCase
) : ViewModel() {

    private val _randomNumber = MutableLiveData<Int>()
    val randomNumber: LiveData<Int> = _randomNumber

    init {
        _randomNumber.value = 0
    }

    fun randomNumberIDOfCharacter() {
        viewModelScope.launch {
            _randomNumber.value = randomNumberIDUseCase.invoke()
        }
    }
}