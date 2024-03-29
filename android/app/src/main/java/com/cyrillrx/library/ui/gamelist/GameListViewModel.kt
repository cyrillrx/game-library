package com.cyrillrx.library.ui.gamelist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cyrillrx.library.data.api.GameApi
import kotlinx.coroutines.launch

class GameListViewModel : ViewModel() {

    var uiState by mutableStateOf(GameListScreenState(games = ArrayList(), isLoading = false))

    fun refresh() {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true)

            val games = GameApi.apiV1.getGames() ?: emptyList()

            uiState = GameListScreenState(games = games, isLoading = false)
        }
    }
}
