package com.example.sportstv.ui_components.grids

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sportstv.ui_components.rv_items.SingleChannelItem
import com.example.sportstv.utils.ChannelDataProvider
import com.example.sportstv.utils.Constants

@Composable
fun PlayerChannelsGrid(
    modifier: Modifier = Modifier
) {
    val scrollState = rememberLazyListState(ChannelDataProvider.currentChannelIndex.intValue)

    LazyColumn(
        modifier = Modifier
            .width(150.dp)
            .padding(bottom = 90.dp)
            .fillMaxHeight()
            .background(Color(0xCC000000))
            .then(modifier),
        state = scrollState,
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(30.dp)
    ) {
        items(Constants.CHANNELS.size) { index ->
            SingleChannelItem(
                modifier = Modifier.alpha(.5f),
                channel = Constants.CHANNELS[index],
                textStyle = TextStyle(
                    fontSize = 8.sp,
                    fontWeight = FontWeight(500),
                    textAlign = TextAlign.Center
                ),
                onChannelClick = {
                    ChannelDataProvider.setCurrentChannel(index)
                }
            )
        }
    }
}

@Preview
@Composable
fun PlayerChannelsGridPreview() {
    PlayerChannelsGrid()
}