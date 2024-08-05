package com.alex.gimenes.portaladventureapp.selection.random.domain

import kotlin.random.Random

class RandomNumberIDUseCaseImpl : RandomNumberIDUseCase {
    override suspend fun invoke(): Int {
        return Random.nextInt(1, 826)
    }
}