package com.example.mmoapp.data.special

import com.example.mmoapp.core.Abstract
import com.example.mmoapp.core.DbWrapper
import com.example.mmoapp.data.special.cache.SpecialDb
import com.example.mmoapp.data.special.cloud.ScreenShotCloud
import com.example.mmoapp.domain.special.SpecialDomain

interface SpecialDataToDomainMapper : Abstract.Mapper {
    fun map(
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
    ): SpecialDomain
}