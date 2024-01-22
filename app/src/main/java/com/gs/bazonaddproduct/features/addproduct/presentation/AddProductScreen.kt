package com.gs.bazonaddproduct.features.addproduct.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.gs.bazonaddproduct.R
import com.gs.bazonaddproduct.ui.theme.ralewayFont

@Composable
fun AddProductScreen(
    navHostController: NavHostController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(Color.White)
            .shadow(
                elevation = 4.dp,
                spotColor = Color(0x40000000),
                ambientColor = Color(0x40000000)
            )
    ) {
        IconButton(onClick = { navHostController.popBackStack() }) {
            Icon(Icons.Default.ArrowBack, contentDescription = null, tint = Color.Black)
        }
        Text(
            text = stringResource(id = R.string.add_product),
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = ralewayFont,
                fontWeight = FontWeight(700),
                color = Color.Black,
            )
        )
    }
}