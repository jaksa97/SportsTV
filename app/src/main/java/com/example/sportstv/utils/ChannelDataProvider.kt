package com.example.sportstv.utils

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.MutableLiveData
import com.example.sportstv.models.ChannelModel

object ChannelDataProvider {

    val currentChannel: MutableLiveData<ChannelModel> = MutableLiveData()
    val currentChannelIndex = mutableIntStateOf(0)

    fun setCurrentChannel(position: Int) {
        currentChannelIndex.intValue = position
        currentChannel.value = Constants.CHANNELS[position]
    }

    fun nextChannel() {
        if (currentChannelIndex.intValue == Constants.CHANNELS.size - 1) {
            currentChannelIndex.intValue = 0
        } else {
            currentChannelIndex.intValue += 1
        }
        currentChannel.value = Constants.CHANNELS[currentChannelIndex.intValue]
    }

    fun prevChannel() {
        if (currentChannelIndex.intValue == 0) {
            currentChannelIndex.intValue = Constants.CHANNELS.size - 1
        } else {
            currentChannelIndex.intValue -= 1
        }
        currentChannel.value = Constants.CHANNELS[currentChannelIndex.intValue]
    }
}