package com.example.mmoapp.domain

import com.example.mmoapp.core.Abstract
import com.example.mmoapp.core.ErrorType
import com.example.mmoapp.presentation.GameListUi

interface GameListDomainToUiMapper : Abstract.Mapper {
    fun map(gameList: List<GameDomain>): GameListUi
    fun map(errorType: ErrorType): GameListUi
}