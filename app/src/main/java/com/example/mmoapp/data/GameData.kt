package com.example.mmoapp.data

import com.example.mmoapp.core.Abstract
import com.example.mmoapp.core.DbWrapper
import com.example.mmoapp.data.cache.GameDataToDbMapper
import com.example.mmoapp.data.cache.GameDb
import com.example.mmoapp.domain.GameDomain
import com.google.gson.annotations.SerializedName

class GameData(
    private val id: Int,
    private val title: String,
    private val description: String,
    private val genre: String,
    private val platform: String,
    private val developer: String,
    private val releaseDate: String
) : Abstract.Object.ToDb<GameDb, GameDataToDbMapper>,
    Abstract.Object<GameDomain, GameDataToDomainMapper> {
    override fun map(mapper: GameDataToDomainMapper) =
        mapper.map(id, title, description, genre, platform, developer, releaseDate)

    override fun mapBy(mapper: GameDataToDbMapper, db: DbWrapper<GameDb>) =
        mapper.mapToDb(id, title, description, genre, platform, developer, releaseDate, db)
}