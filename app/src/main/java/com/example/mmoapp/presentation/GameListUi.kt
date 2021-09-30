package com.example.mmoapp.presentation

import com.example.mmoapp.core.Abstract

sealed class GameListUi : Abstract.Object<Unit, GameListCommunication> {
    data class Base(private val gameList: List<GameUi>) : GameListUi() {
        override fun map(mapper: GameListCommunication) = mapper.map(gameList)
    }
}