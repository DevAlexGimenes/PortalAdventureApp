package com.alex.gimenes.portaladventureapp.selection.random.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.alex.gimenes.portaladventureapp.R
import com.alex.gimenes.portaladventureapp.design_system.view.buttons.ButtonLargeView
import com.alex.gimenes.portaladventureapp.design_system.view.warnings.CardWarningView
import com.alex.gimenes.portaladventureapp.selection.random.presentation.viewmodel.RandomCharacterViewModel
import kotlinx.serialization.Serializable

@Composable
fun RandomCharacterView(
    viewModel: RandomCharacterViewModel = hiltViewModel(),
    onClickToContinue: (Int) -> Unit
) {
    val randomNumber = viewModel.randomNumber.observeAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.padding(top = 50.dp))
        Text(textAlign = TextAlign.Center, text = "Click here to\n Random a character")
        Image(
            modifier = Modifier.size(50.dp),
            imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = "Rick and Morty Image"
        )
        IconButton(
            modifier = Modifier.size(140.dp),
            onClick = { viewModel.randomNumberIDOfCharacter() }
        ) {
            Image(
                modifier = Modifier.size(140.dp),
                painter = painterResource(id = R.drawable.ic_morty_smith),
                contentDescription = "Rick and Morty Image"
            )
        }
        Box(
            modifier = Modifier.clip(RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(20.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = randomNumber.value.toString(),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
        Spacer(modifier = Modifier.padding(top = 50.dp))
        CardWarningView(
            textModifier = Modifier.padding(top = 5.dp, bottom = 15.dp),
            text = "Case you don’t like the number, click again to randon other number",
            icon = Icons.Rounded.Info
        )
        ButtonLargeView(text = "Continue") {
            randomNumber.value?.let {
                onClickToContinue(it)
            }
        }
    }
}

@Serializable
object RandomCharacterRoute
