package com.example.sportstv.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sportstv.screens.ChannelsScreen
import com.example.sportstv.screens.PlayerScreen

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screens.Channels.route
    ) {
        composable(Screens.Channels.route) {
            ChannelsScreen {
                navController.navigate(Screens.Player.route)
            }
        }
        composable(Screens.Player.route) {
            PlayerScreen()
        }
    }
}