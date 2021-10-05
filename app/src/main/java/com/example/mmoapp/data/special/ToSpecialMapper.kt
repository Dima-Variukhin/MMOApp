package com.example.mmoapp.data.special

import com.example.mmoapp.core.Abstract
import com.example.mmoapp.data.special.cloud.ScreenShotCloud

interface ToSpecialMapper : Abstract.Mapper {
    fun map(
        idGame: Int,
        thumbnail: String,
        short_description: String,
        genreGame: String,
        platformGame: String,
        developerGame: String,
        release_dateGame: String,
        os: String,
        processor: String,
        memory: String,
        graphics: String,
        storage: String,
        screenshots: List<ScreenShotCloud>
    ): SpecialData

    class Base : ToSpecialMapper {
        override fun map(
            idGame: Int,
            thumbnail: String,
            short_description: String,
            genreGame: String,
            platformGame: String,
            developerGame: String,
            release_dateGame: String,
            os: String,
            processor: String,
            memory: String,
            graphics: String,
            storage: String,
            screenshots: List<ScreenShotCloud>
        ) = SpecialData(
            idGame,
            thumbnail,
            short_description,
            genreGame,
            platformGame,
            developerGame,
            release_dateGame,
            os,
            processor,
            memory,
            graphics,
            storage,
            screenshots
        )
    }
}