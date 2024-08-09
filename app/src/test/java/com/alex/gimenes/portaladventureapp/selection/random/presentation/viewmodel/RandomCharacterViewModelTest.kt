package com.alex.gimenes.portaladventureapp.selection.random.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.alex.gimenes.portaladventureapp.selection.random.domain.RandomNumberIDUseCase
import com.alex.gimenes.portaladventureapp.selection.random.domain.exception.RandomNumberException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@OptIn(ExperimentalCoroutinesApi::class)
class RandomCharacterViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val testDispatcher = StandardTestDispatcher()

    @Mock
    private lateinit var useCase: RandomNumberIDUseCase
    private lateinit var viewModel: RandomCharacterViewModel
    private lateinit var stateObserver: Observer<Int>

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        viewModel = RandomCharacterViewModel(useCase)
        stateObserver = Observer {}
        viewModel.randomNumber.observeForever(stateObserver)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        viewModel.randomNumber.removeObserver(stateObserver)
    }

    @Test
    fun `get random number from useCase between 1 and 826, return success with value`() = runTest {
        // Given
        Mockito.`when`(useCase.invoke()).thenReturn(FAKE_EXPECTED_NUMBER_SUCCESS)

        // When
        viewModel.randomNumberIDOfCharacter()

        // Then
        advanceUntilIdle()
        assertEquals(FAKE_EXPECTED_NUMBER_SUCCESS, viewModel.randomNumber.value)
    }

    @Test
    fun `get random number from useCase between 1 and 826, return exception with 0`() = runTest {
        // Given
        Mockito.`when`(useCase.invoke()).thenReturn(RandomNumberException().message!!.toInt())

        // When
        viewModel.randomNumberIDOfCharacter()

        // Then
        advanceUntilIdle()
        assertEquals(FAKE_EXPECTED_NUMBER_ERROR, viewModel.randomNumber.value)
    }

    companion object {
        private const val FAKE_EXPECTED_NUMBER_SUCCESS = 53
        private const val FAKE_EXPECTED_NUMBER_ERROR = 0
    }
}