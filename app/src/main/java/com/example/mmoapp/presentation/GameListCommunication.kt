package com.example.mmoapp.presentation

import com.example.mmoapp.core.Communication

interface GameListCommunication : Communication<List<GameUi>> {
    class Base : Communication.Base<List<GameUi>>(), GameListCommunication
}