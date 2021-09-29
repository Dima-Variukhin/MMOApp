package com.example.mmoapp.domain

import com.example.mmoapp.data.GameListDataToDomainMapper
import com.example.mmoapp.data.GamesRepository

interface GamesInteractor {
    suspend fun fetchGamesList(): GameListDomain

    class Base(
        private val gamesRepository: GamesRepository,
        private val mapper: GameListDataToDomainMapper
    ) : GamesInteractor {
        override suspend fun fetchGamesList() = gamesRepository.fetchGamesList().map(mapper)
    }
}