package com.alex.gimenes.portaladventureapp.details.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.alex.gimenes.portaladventureapp.common.state.State
import com.alex.gimenes.portaladventureapp.details.data.datasource.CharacterDetailsWithIDDataSource
import com.alex.gimenes.portaladventureapp.details.domain.model.CharacterDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
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
class CharacterDetailsWithIDRepositoryImplTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val testDispatcher = StandardTestDispatcher()

    @Mock
    private lateinit var characterDetailsWithIDDataSource: CharacterDetailsWithIDDataSource
    private lateinit var repository: CharacterDetailsWithIDRepositoryImpl

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        repository = CharacterDetailsWithIDRepositoryImpl(characterDetailsWithIDDataSource)
    }

    @Test
    fun `get character details on repository with id, return success with data`() = runTest {
        // Given
        Mockito.`when`(characterDetailsWithIDDataSource.getCharacterDetailsWithID(FAKE_CHARACTER_ID))
            .thenReturn(FAKE_CHARACTER_DETAIL)

        // When
        val result = repository.getCharacterWithID(FAKE_CHARACTER_ID)

        // Then
        assertEquals(State.Success(FAKE_CHARACTER_DETAIL), result)
    }

    @Test
    fun `get character details on repository with id, return exception error`() = runTest {
        // Given
        val errorState = State.Error(FAKE_EXCEPTION)
        Mockito.`when`(characterDetailsWithIDDataSource.getCharacterDetailsWithID(FAKE_CHARACTER_ID))
            .thenAnswer { throw FAKE_EXCEPTION }

        // When
        val result = repository.getCharacterWithID(FAKE_CHARACTER_ID)

        // Then
        assertEquals(errorState, result)
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