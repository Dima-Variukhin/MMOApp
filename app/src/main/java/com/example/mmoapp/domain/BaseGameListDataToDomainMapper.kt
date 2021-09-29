package com.example.mmoapp.domain

import com.example.mmoapp.data.GameData
import com.example.mmoapp.data.GameDataToDomainMapper
import com.example.mmoapp.data.GameListDataToDomainMapper
import java.lang.Exception

class BaseGameListDataToDomainMapper(private val gameMapper: GameDataToDomainMapper) :
    GameListDataToDomainMapper() {
    override fun map(data: List<GameData>): GameListDomain {
        val domainList = mutableListOf<GameDomain>()
        data.forEach { gameData ->
            domainList.add(gameData.map(gameMapper))
        }
        return GameListDomain.Success(domainList)
    }

    override fun map(e: Exception) = GameListDomain.Fail(errorType(e))
}
