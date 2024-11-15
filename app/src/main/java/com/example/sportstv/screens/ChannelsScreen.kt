package com.example.sportstv.screens

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.sportstv.MainActivity
import com.example.sportstv.ui_components.grids.ChannelsGrid

@Composable
fun ChannelsScreen(
    onCategoryClick: () -> Unit
) {

    val context = LocalContext.current

    LaunchedEffect(Unit) {
        (context as MainActivity).requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        ChannelsGrid(
            modifier = Modifier.fillMaxSize(),
            onChannelClick = onCategoryClick
        )
    }
}