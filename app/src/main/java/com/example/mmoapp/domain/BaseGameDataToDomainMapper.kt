package com.example.mmoapp.domain

import com.example.mmoapp.data.GameDataToDomainMapper

class BaseGameDataToDomainMapper : GameDataToDomainMapper {
    override fun map(
        id: Int,
        title: String,
        description: String,
        genre: String,
        platform: String,
        developer: String,
        releaseDate: String
    ) = GameDomain.Base(id, title, description, genre, platform, developer, releaseDate)
}