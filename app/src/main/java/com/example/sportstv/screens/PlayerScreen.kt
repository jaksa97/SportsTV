package com.example.sportstv.screens

import android.content.pm.ActivityInfo
import android.os.Build
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.sportstv.MainActivity
import com.example.sportstv.ui_components.player.CustomPlayerView
import com.example.sportstv.utils.ChannelDataProvider

@Composable
fun PlayerScreen() {
    val context = LocalContext.current

    val window = (context as MainActivity).window

    DisposableEffect(Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val insetsController = WindowCompat.getInsetsController(window, window.decorView)
            insetsController.apply {
                hide(WindowInsetsCompat.Type.statusBars())
                systemBarsBehavior =
                    WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        onDispose {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                WindowCompat.getInsetsController(window, window.decorView)
                    .show(WindowInsetsCompat.Type.statusBars())
            } else {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
            }
        }
    }

    LaunchedEffect(Unit) {
        (context as MainActivity).requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        (context as MainActivity).enableEdgeToEdge()
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