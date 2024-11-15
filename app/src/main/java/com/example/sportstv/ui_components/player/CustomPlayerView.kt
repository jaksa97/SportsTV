package com.example.sportstv.ui_components.player

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.example.sportstv.utils.ChannelDataProvider
import com.google.android.exoplayer2.ui.PlayerView

@Composable
fun CustomPlayerView(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val context = LocalContext.current
        val playerView = PlayerView(context)

        DisposableEffect(AndroidView(factory = { playerView })) {
            playerView.player = ChannelDataProvider.player.value
            ChannelDataProvider.player.value?.playWhenReady = true

            onDispose {
                playerView.player = null
            }
        }
    }
}