package com.example.sportstv.utils

import com.example.sportstv.R
import com.example.sportstv.models.ChannelModel

object Constants {

    const val REFERER = "https://ilovetoplay.xyz/"
    const val ORIGIN = "https://ilovetoplay.xyz"
    const val USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/129.0.0.0 Safari/537.36"

    val CHANNELS = listOf(
        ChannelModel(
            name = "Sport Klub 1",
            imageId = R.drawable.sport_klub_1,
            url = "https://xyzdddd.mizhls.ru/lb/premium101/index.m3u8"
        ),
        ChannelModel(
            name = "Sport Klub 2",
            imageId = R.drawable.sport_klub_2,
            url = "https://xyzdddd.mizhls.ru/lb/premium102/index.m3u8"
        ),
        ChannelModel(
            name = "Sport Klub 3",
            imageId = R.drawable.sport_klub_3,
            url = "https://xyzdddd.mizhls.ru/lb/premium103/index.m3u8"
        ),
        ChannelModel(
            name = "Sport Klub 4",
            imageId = R.drawable.sport_klub_4,
            url = "https://xyzdddd.mizhls.ru/lb/premium104/index.m3u8"
        ),
        ChannelModel(
            name = "Sport Klub HD",
            imageId = R.drawable.sport_klub_hd,
            url = "https://xyzdddd.mizhls.ru/lb/premium453/index.m3u8"
        ),
        ChannelModel(
            name = "Arena Sport 1 Premium",
            imageId = R.drawable.arena_sport_1_premium,
            url = "https://xyzdddd.mizhls.ru/lb/premium134/index.m3u8"
        ),
        ChannelModel(
            name = "Arena Sport 2 Premium",
            imageId = R.drawable.arena_sport_2_premium,
            url = "https://xyzdddd.mizhls.ru/lb/premium135/index.m3u8"
        ),
        ChannelModel(
            name = "Arena Sport 3 Premium",
            imageId = R.drawable.arena_sport_3_premium,
            url = "https://xyzdddd.mizhls.ru/lb/premium139/index.m3u8"
        ),
        ChannelModel(
            name = "Arena Sport 1",
            imageId = R.drawable.arena_sport_1,
            url = "https://xyzdddd.mizhls.ru/lb/premium429/index.m3u8"
        ),
        ChannelModel(
            name = "Arena Sport 2",
            imageId = R.drawable.arena_sport_2,
            url = "https://xyzdddd.mizhls.ru/lb/premium430/index.m3u8"
        ),
        ChannelModel(
            name = "Arena Sport 3",
            imageId = R.drawable.arena_sport_3,
            url = "https://xyzdddd.mizhls.ru/lb/premium431/index.m3u8"
        ),
        ChannelModel(
            name = "Arena Sport 4",
            imageId = R.drawable.arena_sport_4,
            url = "https://xyzdddd.mizhls.ru/lb/premium581/index.m3u8"
        )
    )
}