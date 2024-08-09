package com.alex.gimenes.portaladventureapp.selection.random.domain

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.alex.gimenes.portaladventureapp.selection.random.domain.exception.RandomNumberException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

@OptIn(ExperimentalCoroutinesApi::class)
class RandomNumberIDUseCaseImplTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val testDispatcher = StandardTestDispatcher()

    private lateinit var useCase: RandomNumberIDUseCase

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        useCase = mock<RandomNumberIDUseCaseImpl>()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when invoke should return a random number between 1 and 826, with success`() = runTest {
        // Given
        Mockito.`when`(useCase.invoke()).thenReturn(FAKE_RANDOM_NUMBER_SUCCESS)

        // When
        val randomNumber = useCase.invoke()

        // Then
        assertEquals(FAKE_RANDOM_NUMBER_SUCCESS, randomNumber)
    }

    @Test
    fun `when invoke should return random number between 1 and 826, with exception 0`() = runTest {
        // Given
        Mockito.`when`(useCase.invoke()).thenReturn(RandomNumberException().message!!.toInt())

        // When
        val randomNumber = useCase.invoke()

        // Then
        assertEquals(FAKE_RANDOM_NUMBER_ERROR, randomNumber)
    }

    companion object {
        private const val FAKE_RANDOM_NUMBER_SUCCESS = 25
        private const val FAKE_RANDOM_NUMBER_ERROR = 0
    }
}