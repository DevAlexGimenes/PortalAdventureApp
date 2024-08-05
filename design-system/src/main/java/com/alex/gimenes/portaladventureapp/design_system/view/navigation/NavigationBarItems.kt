package com.alex.gimenes.portaladventureapp.design_system.view.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Info
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
sealed class NavigationItem(
    var route: String,
    @Contextual val icon: ImageVector
) {
    @Serializable
    data object Home : NavigationItem(HOME, Icons.Rounded.Home)

    @Serializable
    data object Favorites : NavigationItem(FAVORITES, Icons.Rounded.Favorite)

    @Serializable
    data object About : NavigationItem(ABOUT, Icons.Rounded.Info)
}

const val HOME = "Home"
const val FAVORITES = "Favorites"
const val ABOUT = "About"