package com.adindaviya0052.miniproject2.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adindaviya0052.miniproject2.database.FilmDao
import com.adindaviya0052.miniproject2.model.Film
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(private val dao: FilmDao) : ViewModel() {

    val data: StateFlow<List<Film>> = dao.getFilm().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = emptyList()
    )
    fun undoDelete(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.undoDeleteById(id)
        }
    }
    fun deletePermanent(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }
    val deletedData: StateFlow<List<Film>> = dao.getDeletedBook().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = emptyList()
    )
}