package com.example.mmoapp.domain.special

import com.example.mmoapp.core.Abstract
import com.example.mmoapp.data.special.cloud.ScreenShotCloud
import com.example.mmoapp.presentation.special.SpecialUi

data class SpecialDomain(
    private val idGame: Int,
    private val thumbnail: String,
    private val short_description: String,
    private val genreGame: String,
    private val platformGame: String,
    private val developerGame: String,
    private val release_dateGame: String,
    private val os: String,
    private val processor: String,
    private val memory: String,
    private val graphics: String,
    private val storage: String,
    private val screenshots: List<ScreenShotCloud>,
) : Abstract.Object<SpecialUi, SpecialDomainToUiMapper> {
    override fun map(mapper: SpecialDomainToUiMapper) = mapper.map(
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