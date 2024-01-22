package com.gs.bazonaddproduct.ui.router

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gs.bazonaddproduct.features.addproduct.presentation.AddProductScreen
import com.gs.bazonaddproduct.features.auth.presentation.Login
import com.gs.bazonaddproduct.features.home.presentation.Home

@Composable
fun AppRouter(
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            Login(navController)
        }

        composable("home") {
            Home(navController)
        }

        composable("add-product") {
            AddProductScreen(navHostController = navController)
        }

    }
}