package com.example.mmoapp.domain.special

import com.example.mmoapp.core.Abstract
import com.example.mmoapp.data.special.cloud.ScreenShotCloud
import com.example.mmoapp.presentation.special.SpecialUi

interface SpecialDomainToUiMapper : Abstract.Mapper {
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
        screenshots: List<ScreenShotCloud>,
    ): SpecialUi
}