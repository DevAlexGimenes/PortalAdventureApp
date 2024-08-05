package com.alex.gimenes.portaladventureapp.selection.random.domain

interface RandomNumberIDUseCase {
    suspend fun invoke() : Int
}