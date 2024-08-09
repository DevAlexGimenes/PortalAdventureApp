package com.alex.gimenes.portaladventureapp.details.data.datasource

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.alex.gimenes.portaladventureapp.details.data.api.SearchCharacterWithIDApi
import com.alex.gimenes.portaladventureapp.details.domain.model.CharacterDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
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
class CharacterDetailsWithIDDataSourceImplTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val testDispatcher = StandardTestDispatcher()

    @Mock
    private lateinit var searchCharacterWithIDApi: SearchCharacterWithIDApi
    private lateinit var dataSource: CharacterDetailsWithIDDataSource

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        dataSource = CharacterDetailsWithIDDataSourceImpl(searchCharacterWithIDApi)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `call rick and morty endpoint and get single character, return success`() = runTest {
        // Given
        Mockito.`when`(searchCharacterWithIDApi.getCharacter(FAKE_CHARACTER_ID.toString()))
            .thenReturn(FAKE_CHARACTER_DETAIL)

        // When
        val result = dataSource.getCharacterDetailsWithID(FAKE_CHARACTER_ID)

        // Then
        assertEquals(FAKE_CHARACTER_DETAIL, result)
    }

    companion object {
        private const val FAKE_CHARACTER_ID = 1
        private val FAKE_CHARACTER_DETAIL = CharacterDetails(
            id = 1,
            name = "Rick Sanchez",
            status = "Alive",
            species = "Human"
        )
    }
}