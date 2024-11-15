package com.example.sportstv.navigation

sealed class Screens(val route: String) {
    data object Channels: Screens("categories")
    data object Player: Screens("player")
}