package com.example.mmoapp.data

import com.example.mmoapp.data.cache.GameListCacheDataSource
import com.example.mmoapp.data.cache.GameListCacheMapper
import com.example.mmoapp.data.cloud.GameListCloudDataSource
import com.example.mmoapp.data.cloud.GameListCloudMapper
import java.lang.Exception

interface GamesRepository {
    suspend fun fetchGamesList(): GameListData

    class Base(
        private val cloudDataSource: GameListCloudDataSource,
        private val cacheDataSource: GameListCacheDataSource,
        private val gameListCloudMapper: GameListCloudMapper,
        private val gameListCacheMapper: GameListCacheMapper,
    ) : GamesRepository {
        override suspend fun fetchGamesList() = try {
            val gamesCacheList = cacheDataSource.read()
            if (gamesCacheList.isEmpty()) {
                val gamesCloudList = cloudDataSource.fetchGameList()
                val games = gameListCloudMapper.map(gamesCloudList)
                cacheDataSource.save(games)
                GameListData.Success(games)
            } else {
                GameListData.Success(gameListCacheMapper.map(gamesCacheList))
            }
        } catch (e: Exception) {
            GameListData.Fail(e)
        }
    }
}