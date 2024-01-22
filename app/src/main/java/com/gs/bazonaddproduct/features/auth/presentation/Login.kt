package com.gs.bazonaddproduct.features.auth.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.gs.bazonaddproduct.R
import com.gs.bazonaddproduct.ui.composables.AppBar
import com.gs.bazonaddproduct.ui.theme.Gray
import com.gs.bazonaddproduct.ui.theme.Primary
import com.gs.bazonaddproduct.ui.theme.ralewayFont

@Composable
fun Login(
    navHostController: NavHostController
) {
    Box(modifier = Modifier.fillMaxSize()) {
        AppBar(title = stringResource(id = R.string.login))
        val phone = remember {
            mutableStateOf("")
        }

        val password = remember {
            mutableStateOf("")
        }

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .shadow(elevation = 12.dp)
                .background(Color.White, shape = RoundedCornerShape(2.dp)),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Primary)
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.enter_credentials),
                    color = Color.White,
                    fontFamily = ralewayFont,
                    fontSize = 21.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = phone.value,
                onValueChange = {
                    phone.value = it
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                prefix = {
                    Text(
                        text = "+993 ",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = ralewayFont,
                            fontWeight = FontWeight(500),
                            color = Color.Black,
                        )
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.phone_number),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = ralewayFont,
                            fontWeight = FontWeight(400),
                            color = Gray,
                        )
                    )
                }
            )

            OutlinedTextField(
                value = password.value,
                onValueChange = {
                    password.value = it
                },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.password),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = ralewayFont,
                            fontWeight = FontWeight(400),
                            color = Gray,
                        )
                    )
                }
            )

            Button(
                onClick = {
                    navHostController.navigate("home") {
                        popUpTo("login") {
                            inclusive = true
                        }
                    }
                }, colors = ButtonDefaults.buttonColors(
                    containerColor = Primary
                ), shape = RoundedCornerShape(2.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.enter),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = ralewayFont,
                        fontWeight = FontWeight(600),
                        color = Color.White,
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

        }
    }
}