package com.example.sportstv.utils

import android.net.Uri
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.MutableLiveData
import com.example.sportstv.models.ChannelModel
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource

object ChannelDataProvider {

    val currentChannel: MutableLiveData<ChannelModel> = MutableLiveData()
    val currentChannelIndex = mutableIntStateOf(0)

    val player: MutableLiveData<ExoPlayer?> = MutableLiveData()
    var dataSourceFactory: DefaultHttpDataSource.Factory? = null

    fun setCurrentChannel(position: Int) {
        currentChannelIndex.intValue = position
        currentChannel.value = Constants.CHANNELS[position]
    }

    fun createMediaSource(): HlsMediaSource? {
        return dataSourceFactory?.let {
            HlsMediaSource.Factory(it).createMediaSource(
                MediaItem.fromUri(
                    Uri.parse(
                        currentChannel.value?.url
                    )
                )
            )
        }
    }

    fun createDataSourceFactory() {
        dataSourceFactory = DefaultHttpDataSource.Factory().setUserAgent(Constants.USER_AGENT)
            .setDefaultRequestProperties(creteHeaders())
    }

    private fun creteHeaders(): MutableMap<String, String> {
        val headers = HashMap<String, String>()
        headers["Referer"] = Constants.REFERER
        headers["Origin"] = Constants.ORIGIN

        return headers
    }

    fun nextChannel() {
        if (currentChannelIndex.intValue == Constants.CHANNELS.size - 1) {
            currentChannelIndex.intValue = 0
        } else {
            currentChannelIndex.intValue += 1
        }
        currentChannel.value = Constants.CHANNELS[currentChannelIndex.intValue]
        createMediaSource()?.let { player.value?.setMediaSource(it) }
        player.value?.playWhenReady = true
    }

    fun prevChannel() {
        if (currentChannelIndex.intValue == 0) {
            currentChannelIndex.intValue = Constants.CHANNELS.size - 1
        } else {
            currentChannelIndex.intValue -= 1
        }
        currentChannel.value = Constants.CHANNELS[currentChannelIndex.intValue]
        createMediaSource()?.let { player.value?.setMediaSource(it) }
        player.value?.playWhenReady = true
    }
}