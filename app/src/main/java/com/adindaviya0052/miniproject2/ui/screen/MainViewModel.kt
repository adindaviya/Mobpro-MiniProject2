package com.adindaviya0052.miniproject2.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adindaviya0052.miniproject2.database.FilmDao
import com.adindaviya0052.miniproject2.model.Film
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class MainViewModel(dao: FilmDao) : ViewModel() {

    val data: StateFlow<List<Film>> = dao.getFilm().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = emptyList()
    )

    fun getFilm(id: Long): Film? {
        return data.value.find { it.id == id }
    }
}