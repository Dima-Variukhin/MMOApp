package com.example.mmoapp.data.special.cache

import com.example.mmoapp.core.Abstract
import com.example.mmoapp.core.DbWrapper
import com.example.mmoapp.data.special.cloud.ScreenShotCloud

interface SpecialDataToDbMapper : Abstract.Mapper {
    fun mapToDb(
        idGame: Int,
        thumbnail: String,
        shortDescription: String,
        genreGame: String,
        platformGame: String,
        developerGame: String,
        releaseDate: String,
        os: String,
        processor: String,
        memory: String,
        graphics: String,
        storage: String,
        screenshots: List<ScreenShotCloud>,
        db: DbWrapper<SpecialDb>
    ): SpecialDb

    class Base : SpecialDataToDbMapper {
        override fun mapToDb(
            idGame: Int,
            thumbnail: String,
            shortDescription: String,
            genreGame: String,
            platformGame: String,
            developerGame: String,
            releaseDate: String,
            os: String,
            processor: String,
            memory: String,
            graphics: String,
            storage: String,
            screenshots: List<ScreenShotCloud>,
            db: DbWrapper<SpecialDb>
        ) = db.createObject(idGame).apply {
            this.idGame = idGame
            this.thumbnail = thumbnail
            this.shortDescription = shortDescription
            this.genreGame = genreGame
            this.platformGame = platformGame
            this.developerGame = developerGame
            this.releaseDate = releaseDate
            this.os = os
            this.processor = processor
            this.memory = memory
            this.graphics = graphics
            this.storage = storage
            this.screenshots = screenshots
        }
    }
}