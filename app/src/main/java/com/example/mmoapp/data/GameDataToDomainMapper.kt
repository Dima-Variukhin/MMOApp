package com.example.mmoapp.data

import com.example.mmoapp.core.Abstract
import com.example.mmoapp.domain.GameDomain

interface GameDataToDomainMapper : Abstract.Mapper {
    fun map(
        id: Int,
        title: String,
        description: String,
        genre: String,
        platform: String,
        developer: String,
        releaseDate: String
    ): GameDomain
}