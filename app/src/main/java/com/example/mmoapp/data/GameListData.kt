package com.example.mmoapp.data

import com.example.mmoapp.core.Abstract
import com.example.mmoapp.domain.GameListDomain
import java.lang.Exception

sealed class GameListData : Abstract.Object<GameListDomain, GameListDataToDomainMapper> {
    data class Success(private val games: List<GameData>) : GameListData() {
        override fun map(mapper: GameListDataToDomainMapper) = mapper.map(games)
    }

    data class Fail(private val e: Exception) : GameListData() {
        override fun map(mapper: GameListDataToDomainMapper) = mapper.map(e)
    }
}