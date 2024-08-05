package com.alex.gimenes.portaladventureapp.bottom.navigation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.alex.gimenes.portaladventureapp.R
import com.alex.gimenes.portaladventureapp.design_system.view.buttons.ButtonLargeView

@Composable
fun HomeScreenView(
    onSearchCharacter: () -> Unit,
    onRandomCharacter: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier.size(250.dp),
            painter = painterResource(id = R.drawable.ic_rick_and_morty),
            contentDescription = "Rick and Morty Image"
        )
        Spacer(modifier = Modifier.padding(top = 50.dp))
        ButtonLargeView(text = "Search characters", icon = Icons.Default.Search) {
            onSearchCharacter()
        }
        ButtonLargeView(text = "Random", icon = ImageVector.vectorResource(id = R.drawable.ic_shuffle) ) {
            onRandomCharacter()
        }
    }
}