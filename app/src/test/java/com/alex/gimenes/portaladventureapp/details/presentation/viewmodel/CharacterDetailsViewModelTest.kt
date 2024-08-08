package com.alex.gimenes.portaladventureapp.details.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.alex.gimenes.portaladventureapp.common.state.State
import com.alex.gimenes.portaladventureapp.details.domain.model.CharacterDetails
import com.alex.gimenes.portaladventureapp.details.domain.repository.CharacterDetailsWithIDRepository
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
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class CharacterDetailsViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val testDispatcher = StandardTestDispatcher()

    @Mock
    private lateinit var characterDetailsWithIDRepository: CharacterDetailsWithIDRepository
    private lateinit var viewModel: CharacterDetailsViewModel
    private lateinit var stateObserver: Observer<State<CharacterDetails>>

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        viewModel = CharacterDetailsViewModel(characterDetailsWithIDRepository)
        stateObserver = Observer {}
        viewModel.validationEvent.observeForever(stateObserver)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        viewModel.validationEvent.removeObserver(stateObserver)
    }

    @Test
    fun `get character details with id, return success with values`() = runTest {
        // Given
        Mockito.`when`(characterDetailsWithIDRepository.getCharacterWithID(FAKE_CHARACTER_ID))
            .thenReturn(State.Success(FAKE_CHARACTER_DETAIL))

        // When
        viewModel.getCharacterWithID(FAKE_CHARACTER_ID)

        // Then
        advanceUntilIdle()
        assertEquals(State.Success(FAKE_CHARACTER_DETAIL), viewModel.validationEvent.value)
    }

    @Test
    fun `get character details with id, return exception error`() = runTest {
        // Given
        val errorState = State.Error(FAKE_EXCEPTION)
        Mockito.`when`(characterDetailsWithIDRepository.getCharacterWithID(FAKE_CHARACTER_ID))
            .thenReturn(errorState)

        // When
        viewModel.getCharacterWithID(FAKE_CHARACTER_ID)

        // Then
        advanceUntilIdle()
        assertEquals(errorState, viewModel.validationEvent.value)
    }

    companion object {
        private val FAKE_EXCEPTION = Exception("Network error")
        private const val FAKE_CHARACTER_ID = 1
        private val FAKE_CHARACTER_DETAIL = CharacterDetails(
            id = 1,
            name = "Rick Sanchez",
            status = "Alive",
            species = "Human"
        )
    }
}