package com.example.sportstv

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.sportstv.navigation.NavGraph
import com.example.sportstv.ui.theme.SportsTVTheme
import com.example.sportstv.utils.ChannelDataProvider
import com.google.android.exoplayer2.ExoPlayer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPlayer(this)

        setContent()
    }

    override fun onDestroy() {
        super.onDestroy()
        ChannelDataProvider.player.value?.release()
        ChannelDataProvider.player.value = null
        ChannelDataProvider.dataSourceFactory = null
    }

    private fun setContent() {
        setContent {
            SportsTVTheme {
                val navController = rememberNavController()
                NavGraph(navController)
            }
        }
    }

    private fun initPlayer(context: Context) {
        if (ChannelDataProvider.player.value == null) {
            ChannelDataProvider.player.value = ExoPlayer.Builder(context).build()

            if (ChannelDataProvider.dataSourceFactory == null) {
                ChannelDataProvider.createDataSourceFactory()
            }
        }
    }
}