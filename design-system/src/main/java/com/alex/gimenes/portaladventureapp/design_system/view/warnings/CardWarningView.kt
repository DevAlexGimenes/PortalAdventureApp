package com.alex.gimenes.portaladventureapp.design_system.view.warnings

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alex.gimenes.portaladventureapp.design_system.themes.PortalAdventureAppTheme

@Composable
fun CardWarningView(
    modifier: Modifier = Modifier,
    background: Color = MaterialTheme.colorScheme.tertiary,
    textModifier: Modifier = Modifier,
    text: String,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    iconModifier: Modifier = Modifier,
    icon: ImageVector,
    iconTint: Color = MaterialTheme.colorScheme.onPrimary,
    contentDescription: String = ""
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        colors = CardDefaults.cardColors(background)
    ) {
        Row {
            Icon(
                modifier = iconModifier
                    .align(Alignment.CenterVertically)
                    .padding(15.dp),
                imageVector = icon,
                tint = iconTint,
                contentDescription = contentDescription
            )
            Text(
                modifier = textModifier.padding(top = 15.dp, end = 15.dp),
                style = MaterialTheme.typography.bodyMedium,
                color = textColor,
                text = text,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCardWarningView() {
    PortalAdventureAppTheme {
        CardWarningView(
            text = "Case you don’t like the number, click again to randon other number\n",
            icon = Icons.Default.Info
        )
    }
}