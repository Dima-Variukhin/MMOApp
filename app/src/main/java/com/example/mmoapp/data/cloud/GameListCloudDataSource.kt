package com.example.mmoapp.data.cloud

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

interface GameListCloudDataSource {

    suspend fun fetchGameList(): List<GameCloud>

    class Base(private val gson: Gson, private val service: GameListService) :
        GameListCloudDataSource {
        override suspend fun fetchGameList(): List<GameCloud> = gson.fromJson(
            service.fetchGameList().string(),
            object : TypeToken<List<GameCloud>>() {}.type
        )
    }
}