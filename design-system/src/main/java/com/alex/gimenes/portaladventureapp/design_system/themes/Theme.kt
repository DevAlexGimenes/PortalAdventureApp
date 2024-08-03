package com.alex.gimenes.portaladventureapp.design_system.themes

import android.app.Activity
import android.os.Build
import android.provider.CalendarContract.Colors
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.alex.gimenes.portaladventureapp.design_system.colors.Black000000
import com.alex.gimenes.portaladventureapp.design_system.colors.CyanA6CCCC
import com.alex.gimenes.portaladventureapp.design_system.colors.Green60A85F
import com.alex.gimenes.portaladventureapp.design_system.colors.Green88E13C
import com.alex.gimenes.portaladventureapp.design_system.colors.WhiteFFFFFF
import com.alex.gimenes.portaladventureapp.design_system.colors.YellowEBE481
import com.alex.gimenes.portaladventureapp.design_system.type.Typography

private val LightColorScheme = lightColorScheme(
    primary = CyanA6CCCC,
    secondary = Green60A85F,
    tertiary = YellowEBE481,
    onPrimary = Black000000,
    onSecondary = WhiteFFFFFF,
    background = Green88E13C
)

@Composable
fun PortalAdventureAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> TODO()
        else -> LightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.secondary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}