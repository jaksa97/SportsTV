package com.example.sportstv.ui_components.player

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.example.sportstv.R
import com.example.sportstv.utils.ChannelDataProvider
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.ui.R as exoR


@Composable
fun CustomPlayerView(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier)
    ) {
        val context = LocalContext.current

        AndroidView(factory = {
            val inflater = LayoutInflater.from(context)
            inflater.inflate(R.layout.custom_player_view, null, false).apply {
                val playerView = this.findViewById<PlayerView>(R.id.player_view)
                playerView.apply {
                    this.player = ChannelDataProvider.player.value
                    useController = true

                    findViewById<TextView>(R.id.channel_name).text =
                        ChannelDataProvider.currentChannel.value?.name

                    // Set custom behavior for Next and Previous buttons
                    findViewById<View>(exoR.id.exo_next)?.setOnClickListener {
                        ChannelDataProvider.nextChannel()
                    }
                    findViewById<View>(exoR.id.exo_prev)?.setOnClickListener {
                        ChannelDataProvider.prevChannel()
                    }
                }
            }
        }, modifier = Modifier.fillMaxSize())

        DisposableEffect(Unit) {
            ChannelDataProvider.player.value?.playWhenReady = true

            onDispose {
                ChannelDataProvider.player.value?.release()
            }
        }
    }
}