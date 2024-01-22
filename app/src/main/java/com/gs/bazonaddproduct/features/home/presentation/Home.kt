package com.gs.bazonaddproduct.features.home.presentation

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.gs.bazonaddproduct.R
import com.gs.bazonaddproduct.activity.CodeScan
import com.gs.bazonaddproduct.ui.composables.AppBar
import com.gs.bazonaddproduct.ui.theme.Gray
import com.gs.bazonaddproduct.ui.theme.Red
import com.gs.bazonaddproduct.ui.theme.ralewayFont

@Composable
fun Home(navController: NavHostController) {
    val search = remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        Column(modifier = Modifier.weight(1f)) {
            AppBar(title = stringResource(id = R.string.app_name)) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painterResource(id = R.drawable.ant_design_setting_outlined),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                HomeCard(
                    title = stringResource(id = R.string.working_products),
                    description = stringResource(id = R.string.working_products_description),
                    icon = R.drawable.product
                ) {

                }
                HomeCard(
                    title = stringResource(id = R.string.add_image),
                    description = stringResource(id = R.string.add_image_description),
                    icon = R.drawable.add_photo
                ) {

                }
                HomeCard(
                    title = stringResource(id = R.string.add_product),
                    description = stringResource(id = R.string.add_product_description),
                    icon = R.drawable.basil_add_outline
                ) {
                    navController.navigate("add-product")
                }
            }
        }
        Row(
            modifier = Modifier
                .padding(bottom = 22.dp, start = 16.dp, end = 16.dp)
                .shadow(
                    elevation = 12.3.dp,
                    spotColor = Color(0x40000000),
                    ambientColor = Color(0x40000000)
                )
                .fillMaxWidth()
                .background(color = Color.White)
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.mynaui_search),
                    contentDescription = null,
                    tint = Gray
                )

                BasicTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = search.value,
                    onValueChange = {
                        search.value = it
                    },
                    decorationBox = { innerTextField ->

                        if (search.value.isEmpty())
                            Text(
                                text = stringResource(id = R.string.search_by_number),
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontFamily = ralewayFont,
                                    fontWeight = FontWeight(400),
                                    color = Gray
                                )
                            )
                        innerTextField.invoke()
                    }
                )
            }

            IconButton(onClick = {
                context.startActivity(Intent(context, CodeScan::class.java))
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ph_barcode),
                    contentDescription = null,
                    tint = Red
                )
            }

        }
    }
}