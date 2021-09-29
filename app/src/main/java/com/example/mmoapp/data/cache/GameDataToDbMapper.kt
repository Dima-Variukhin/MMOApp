package com.example.mmoapp.data.cache

import com.example.mmoapp.core.Abstract
import com.example.mmoapp.core.DbWrapper

interface GameDataToDbMapper : Abstract.Mapper {
    fun mapToDb(
        id: Int,
        title: String,
        description: String,
        genre: String,
        platform: String,
        developer: String,
        releaseDate: String,
        db: DbWrapper<GameDb>
    ): GameDb

    class Base : GameDataToDbMapper {
        override fun mapToDb(
            id: Int,
            title: String,
            description: String,
            genre: String,
            platform: String,
            developer: String,
            releaseDate: String,
            db: DbWrapper<GameDb>
        ): GameDb {
            val gameDb = db.createObject(id)
            gameDb.title = title
            gameDb.description = description
            gameDb.genre = genre
            gameDb.platform = platform
            gameDb.developer = developer
            gameDb.releaseDate = releaseDate
            return gameDb
        }
    }
}