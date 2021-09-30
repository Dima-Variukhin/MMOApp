package com.example.mmoapp.presentation

import com.example.mmoapp.core.ResourceProvider
import com.example.mmoapp.domain.GameDomainToUiMapper

class BaseGameDomainToUiMapper(private val resourceProvider: ResourceProvider) :
    GameDomainToUiMapper {
    override fun map(
        id: Int,
        title: String,
        description: String,
        genre: String,
        platform: String,
        developer: String,
        releaseDate: String
    ) = GameUi.Base(id, title, description, genre, platform, developer, releaseDate)
}