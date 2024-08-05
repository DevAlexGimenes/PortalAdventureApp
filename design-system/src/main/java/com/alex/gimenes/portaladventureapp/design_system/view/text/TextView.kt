package com.alex.gimenes.portaladventureapp.design_system.view.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextLabelInfo(
    label: String,
    value: String,
    labelColor: Color = Color.Black,
    valueColor: Color = Color.Black
) {
    Row(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = "$label ",
            color = labelColor,
            fontSize = 18.sp,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = value,
            color = valueColor,
            fontSize = 18.sp,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}