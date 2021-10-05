package com.example.mmoapp.domain.special

import com.example.mmoapp.data.special.SpecialDataToDomainMapper
import com.example.mmoapp.data.special.cloud.ScreenShotCloud

class BaseSpecialDataToDomainMapper : SpecialDataToDomainMapper {
    override fun map(
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
        screenshots: List<ScreenShotCloud>
    ) = SpecialDomain(
        idGame,
        thumbnail,
        shortDescription,
        genreGame,
        platformGame,
        developerGame,
        releaseDate,
        os,
        processor,
        memory,
        graphics,
        storage,
        screenshots
    )
}