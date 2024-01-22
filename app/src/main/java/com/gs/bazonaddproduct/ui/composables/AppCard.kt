package com.gs.bazonaddproduct.ui.composables

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val appCard = Modifier.shadow(
    elevation = 4.dp,
    spotColor = Color(0x40000000),
    ambientColor = Color(0x40000000)
)