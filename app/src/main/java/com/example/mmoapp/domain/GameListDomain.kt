package com.example.mmoapp.domain

import com.example.mmoapp.core.Abstract
import com.example.mmoapp.core.ErrorType
import com.example.mmoapp.presentation.GameListUi

sealed class GameListDomain : Abstract.Object<GameListUi, GameListDomainToUiMapper> {
    data class Success(
        private val gameList: List<GameDomain>
    ) : GameListDomain() {
        override fun map(mapper: GameListDomainToUiMapper) = mapper.map(gameList)
    }

    data class Fail(private val errorType: ErrorType) : GameListDomain() {
        override fun map(mapper: GameListDomainToUiMapper) = mapper.map(errorType)
    }
}