package com.example.mmoapp.domain

import com.example.mmoapp.core.Abstract
import com.example.mmoapp.presentation.GameUi

sealed class GameDomain : Abstract.Object<GameUi, GameDomainToUiMapper> {
    data class Base(
        private val id: Int,
        private val title: String,
        private val description: String,
        private val genre: String,
        private val platform: String,
        private val developer: String,
        private val releaseDate: String
    ) : GameDomain() {
        override fun map(mapper: GameDomainToUiMapper) =
            mapper.map(id, title, description, genre, platform, developer, releaseDate)
    }
}