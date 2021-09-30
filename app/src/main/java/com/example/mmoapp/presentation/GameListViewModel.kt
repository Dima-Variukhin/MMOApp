package com.example.mmoapp.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mmoapp.core.Communication
import com.example.mmoapp.domain.GameListDomainToUiMapper
import com.example.mmoapp.domain.GamesInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class GameListViewModel(
    private val gamesInteractor: GamesInteractor,
    private val mapper: GameListDomainToUiMapper,
    private val communication: GameListCommunication,
) : ViewModel() {

    fun fetchGamesList() {
        communication.map(listOf(GameUi.Progress))
        viewModelScope.launch(Dispatchers.IO) {
            val resultDomain = gamesInteractor.fetchGamesList()
            val resultUi = resultDomain.map(mapper)
            withContext(Dispatchers.Main) {
                resultUi.map(communication)
            }
        }
    }

    fun observer(owner: LifecycleOwner, observer: Observer<List<GameUi>>) {
        communication.observe(owner, observer)
    }
}