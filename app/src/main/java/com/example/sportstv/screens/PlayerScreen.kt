package com.example.sportstv.screens

import android.content.pm.ActivityInfo
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.sportstv.MainActivity
import com.example.sportstv.ui_components.player.CustomPlayerView
import com.example.sportstv.utils.ChannelDataProvider

@Composable
fun PlayerScreen() {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        (context as MainActivity).requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        ChannelDataProvider.createMediaSource()
            ?.let { ChannelDataProvider.player.value?.setMediaSource(it) }
        ChannelDataProvider.player.value?.apply {
            prepare()
            play()
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomPlayerView()
    }
}