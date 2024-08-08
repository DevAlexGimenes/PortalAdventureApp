package com.alex.gimenes.portaladventureapp.selection.random.domain

import com.alex.gimenes.portaladventureapp.selection.random.domain.exception.RandomNumberException
import kotlin.random.Random

class RandomNumberIDUseCaseImpl : RandomNumberIDUseCase {
    override suspend fun invoke(): Int {
        return try {
           Random.nextInt(1, 826)
        } catch (e: Exception) {
          RandomNumberException().message!!.toInt()
        }
    }
}