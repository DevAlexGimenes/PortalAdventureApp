package com.alex.gimenes.portaladventureapp.design_system.view.buttons

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alex.gimenes.portaladventureapp.design_system.themes.PortalAdventureAppTheme

@Composable
fun ButtonLargeView(
    modifier: Modifier = Modifier,
    background: Color = MaterialTheme.colorScheme.primary,
    textModifier: Modifier = Modifier,
    text: String,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(2.dp))
            .padding(15.dp),
        colors = ButtonDefaults.buttonColors(background),
        onClick = { onClick() },
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            modifier = textModifier.padding(5.dp),
            text = text,
            color = textColor,
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Composable
fun ButtonLargeView(
    modifier: Modifier = Modifier,
    background: Color = MaterialTheme.colorScheme.primary,
    textModifier: Modifier = Modifier,
    text: String,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    iconModifier: Modifier = Modifier,
    icon: ImageVector,
    iconTint: Color = MaterialTheme.colorScheme.onPrimary,
    contentDescription: String = "",
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(2.dp))
            .padding(15.dp),
        colors = ButtonDefaults.buttonColors(background),
        onClick = { onClick() },
        shape = RoundedCornerShape(10.dp)
    ) {
        Icon(
            modifier = iconModifier,
            imageVector = icon,
            tint = iconTint,
            contentDescription = contentDescription
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            modifier = textModifier.padding(5.dp),
            text = text,
            color = textColor,
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewButtonLargeView() {
    PortalAdventureAppTheme {
        ButtonLargeView(text = "Continue") {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewButtonLargeViewWithIcon() {
    PortalAdventureAppTheme {
        ButtonLargeView(
            text = "Continue",
            icon = Icons.Default.AccountBox
        ) {

        }
    }
}