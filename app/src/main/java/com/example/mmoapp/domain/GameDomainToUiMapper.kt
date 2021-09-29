package com.example.mmoapp.domain

import com.example.mmoapp.core.Abstract
import com.example.mmoapp.presentation.GameUi

interface GameDomainToUiMapper : Abstract.Mapper {
    fun map(
        id: Int,
        title: String,
        description: String,
        genre: String,
        platform: String,
        developer: String,
        releaseDate: String
    ): GameUi
}