package com.adindaviya0052.miniproject2.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adindaviya0052.miniproject2.database.FilmDao
import com.adindaviya0052.miniproject2.model.Film
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(private val dao: FilmDao) : ViewModel() {

    fun insert(judul: String, review: String, kategori: String, status: String, tanggal: Long?) {
        val film = Film(
            judul = judul,
            review = review,
            kategori = kategori,
            status = status,
            tanggal = tanggal
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(film)
        }
    }

    fun getFilm(id: Long): Film? {
        return null
    }
}