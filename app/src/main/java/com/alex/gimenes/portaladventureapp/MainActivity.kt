package com.alex.gimenes.portaladventureapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alex.gimenes.portaladventureapp.bottom.navigation.about.AboutScreenView
import com.alex.gimenes.portaladventureapp.design_system.themes.PortalAdventureAppTheme
import com.alex.gimenes.portaladventureapp.design_system.view.navigation.BottomNavigationBar
import com.alex.gimenes.portaladventureapp.design_system.view.navigation.NavigationItem
import com.alex.gimenes.portaladventureapp.bottom.navigation.favorites.FavoriteScreenView
import com.alex.gimenes.portaladventureapp.bottom.navigation.home.HomeScreenView
import com.alex.gimenes.portaladventureapp.selection.random.presentation.view.RandomCharacterRoute
import com.alex.gimenes.portaladventureapp.selection.random.presentation.view.RandomCharacterView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            PortalAdventureAppTheme {
                val navController = rememberNavController()
                var selectedItem by remember { mutableStateOf("") }
                var showTopAppBar by remember { mutableStateOf(false) }
                var showBottomAppBar by remember { mutableStateOf(false) }

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    textAlign = TextAlign.Center,
                                    text = selectedItem,
                                    style = MaterialTheme.typography.titleMedium
                                )
                            },
                            colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.secondary),
                            navigationIcon = {
                                if (showTopAppBar) {
                                    IconButton(onClick = { navController.popBackStack() }) {
                                        Icon(
                                            imageVector = Icons.Default.ArrowBack,
                                            contentDescription = ""
                                        )
                                    }
                                }
                            },
                        )
                    },
                    bottomBar = {
                        if (showBottomAppBar) {
                            BottomAppBar(
                                modifier = Modifier,
                                containerColor = MaterialTheme.colorScheme.primary
                            ) {
                                BottomNavigationBar(
                                    navController = navController,
                                    items = listOf(
                                        NavigationItem.Home,
                                        NavigationItem.Favorites,
                                        NavigationItem.About
                                    )
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = NavigationItem.Home.route
                        ) {
                            composable(NavigationItem.Home.route) {
                                selectedItem = NavigationItem.Home.title
                                showTopAppBar = false
                                showBottomAppBar = true
                                HomeScreenView(
                                    onRandomCharacter = {
                                        navController.navigate(RandomCharacterRoute)
                                    },
                                    onSearchCharacter = {

                                    }
                                )
                            }
                            composable(NavigationItem.Favorites.route) {
                                selectedItem = NavigationItem.Favorites.title
                                showTopAppBar = false
                                showBottomAppBar = true
                                FavoriteScreenView()
                            }
                            composable(NavigationItem.About.route) {
                                selectedItem = NavigationItem.About.title
                                showTopAppBar = false
                                showBottomAppBar = true
                                AboutScreenView()
                            }
                            composable<RandomCharacterRoute> {
                                selectedItem = "Random character"
                                showTopAppBar = true
                                showBottomAppBar = false
                                RandomCharacterView {

                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
