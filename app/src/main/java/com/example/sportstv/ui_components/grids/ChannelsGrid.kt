package com.example.sportstv.ui_components.grids

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sportstv.ui_components.rv_items.SingleChannelItem
import com.example.sportstv.utils.Constants

@Composable
fun ChannelsGrid(
    modifier: Modifier = Modifier,
    onChannelClick: (Int) -> Unit
) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(Constants.CHANNELS.size) { index ->
            SingleChannelItem(
                channel = Constants.CHANNELS[index],
                onChannelClick = {
                    onChannelClick.invoke(index)
                }
            )
        }
    }
}

@Preview
@Composable
fun ChannelsGridPreview() {
    ChannelsGrid {

    }
}