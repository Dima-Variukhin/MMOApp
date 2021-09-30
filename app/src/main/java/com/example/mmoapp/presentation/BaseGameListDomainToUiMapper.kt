package com.example.mmoapp.presentation

import com.example.mmoapp.R
import com.example.mmoapp.core.ErrorType
import com.example.mmoapp.core.ResourceProvider
import com.example.mmoapp.domain.GameDomain
import com.example.mmoapp.domain.GameDomainToUiMapper
import com.example.mmoapp.domain.GameListDomainToUiMapper

class BaseGameListDomainToUiMapper(
    private val resourcesProvider: ResourceProvider,
    private val gameMapper: GameDomainToUiMapper
) : GameListDomainToUiMapper {
    override fun map(gameList: List<GameDomain>) = GameListUi.Base(gameList.map { game ->
        game.map(gameMapper)
    })

    override fun map(errorType: ErrorType): GameListUi {
        val messageId = when (errorType) {
            ErrorType.NO_CONNECTION -> R.string.no_connection_message
            ErrorType.SERVICE_UNAVAILABLE -> R.string.service_unavailable_message
            else -> R.string.something_went_wrong
        }
        val message = resourcesProvider.getString(messageId)
        return GameListUi.Base(listOf(GameUi.Fail(message)))
    }
}