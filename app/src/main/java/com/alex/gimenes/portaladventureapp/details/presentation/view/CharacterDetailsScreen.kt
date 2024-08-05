package com.alex.gimenes.portaladventureapp.details.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.alex.gimenes.portaladventureapp.R
import com.alex.gimenes.portaladventureapp.common.state.State
import com.alex.gimenes.portaladventureapp.design_system.colors.GRAY6A6A6A
import com.alex.gimenes.portaladventureapp.design_system.view.feedback.FeedbackView
import com.alex.gimenes.portaladventureapp.design_system.view.loading.LoadingView
import com.alex.gimenes.portaladventureapp.design_system.view.text.TextLabelInfo
import com.alex.gimenes.portaladventureapp.details.domain.model.CharacterDetails
import com.alex.gimenes.portaladventureapp.details.presentation.viewmodel.CharacterDetailsViewModel
import kotlinx.serialization.Serializable

@Composable
fun CharacterDetailsScreen(
    viewModel: CharacterDetailsViewModel = hiltViewModel(),
    characterID: Int,
    onError: () -> Unit
) {
    LaunchedEffect(characterID) {
        viewModel.getCharacterWithID(characterID)
    }

    val randomNumber = viewModel.validationEvent.observeAsState()

    when (randomNumber.value) {
        is State.Loading -> {
            LoadingView()
        }

        is State.Success -> {
            CharacterProfile((randomNumber.value as State.Success<CharacterDetails>).data)
        }

        is State.Error -> {
            FeedbackView(
                title = "Sorry!",
                description = "We could not get your character, try again!",
                painter = painterResource(id = R.drawable.ic_morty_smith),
                icon = Icons.Rounded.Info,
                iconTint = Color.Red,
                textButton = "Try again!",
                colorButton = Color.Red,
                onPositiveButton = onError
            )
        }

        else -> {}
    }
}

@Composable
fun CharacterProfile(character: CharacterDetails) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(220.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = character.image,
                contentDescription = "Rick Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary),
            contentAlignment = Alignment.CenterStart
        ) {
            Column(modifier = Modifier.padding(15.dp)) {
                TextLabelInfo("Name:", character.name!!, MaterialTheme.colorScheme.onSecondary)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colorScheme.primary)
                .padding(bottom = 15.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Column(modifier = Modifier.padding(15.dp)) {
                CharacterStatus(character.status!!)
                TextLabelInfo("Species:", character.species!!, labelColor = GRAY6A6A6A)
                TextLabelInfo("Gender:", character.gender!!, labelColor = GRAY6A6A6A)
            }
        }
    }
}

@Composable
fun CharacterStatus(status: String) {
    when (status) {
        "Alive" -> {
            TextLabelInfo("Status:", status, labelColor = GRAY6A6A6A, valueColor = Color.Green)
        }

        "Dead" -> {
            TextLabelInfo("Status:", status, labelColor = GRAY6A6A6A, valueColor = Color.Red)
        }

        else -> {
            TextLabelInfo("Status:", status, labelColor = GRAY6A6A6A, valueColor = Color.Gray)
        }
    }
}


@Serializable
data class CharacterDetailsRoute(val numberId: Int)