package com.alex.gimenes.portaladventureapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alex.gimenes.portaladventureapp.about.AboutScreenView
import com.alex.gimenes.portaladventureapp.design_system.themes.PortalAdventureAppTheme
import com.alex.gimenes.portaladventureapp.design_system.view.navigation.BottomNavigationBar
import com.alex.gimenes.portaladventureapp.design_system.view.navigation.NavigationItem
import com.alex.gimenes.portaladventureapp.favorites.FavoriteScreenView
import com.alex.gimenes.portaladventureapp.home.HomeScreenView

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            PortalAdventureAppTheme {
                val navController = rememberNavController()
                var selectedItem by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }

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
                                if (show) {
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
                ) { innerPadding ->
                    Box(
                        modifier = Modifier.padding(
                            PaddingValues(
                                0.dp,
                                0.dp,
                                0.dp,
                                innerPadding.calculateBottomPadding()
                            )
                        )
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = NavigationItem.Home.route
                        ) {
                            composable(NavigationItem.Home.route) {
                                selectedItem = NavigationItem.Home.title
                                show = false
                                HomeScreenView()
                            }
                            composable(NavigationItem.Favorites.route) {
                                selectedItem = NavigationItem.Favorites.title
                                show = false
                                FavoriteScreenView()
                            }
                            composable(NavigationItem.About.route) {
                                selectedItem = NavigationItem.About.title
                                show = false
                                AboutScreenView()
                            }
                        }
                    }
                }
            }
        }
    }
}
