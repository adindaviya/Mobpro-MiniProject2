package com.adindaviya0052.miniproject2.ui.screen

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.adindaviya0052.miniproject2.model.Film

class MainViewModel : ViewModel() {

    val data = listOf(
        Film(
            1,
            "Mendadak dangdut",
            "Lucuu banget keanu",
            "Film Indonesia",
            "Selesai ditonton",
            parseDateToMillis("2025-04-30")
        ),
        Film(
            2,
            "True beauty",
            "Mengajarkan kita untuk tidak insecure, Cha Eun Woo ganteng",
            "Drama Korea",
            "Selesai ditonton",
            parseDateToMillis("2025-05-01")
        ),
        Film(
            3,
            "Memory of encaustic tile",
            "Kerenn, baru episode awal sudah menarik",
            "Drama Cina",
            "Sedang ditonton",
            parseDateToMillis("2025-05-02")
        ),
        Film(
            4,
            "Jumbo",
            "Film animasi bestt",
            "Film Animasi",
            "Belum ditonton",
            parseDateToMillis("2025-05-03")
        ),
        Film(
            5,
            "Enola holmes",
            "Best aku suka film barat detektif seperti ini",
            "Film Hollywood",
            "Selesai ditonton",
            parseDateToMillis("2025-05-03")
        )
    )

    fun getCatatan(id: Long): Film? {
        return data.find { it.id == id }
    }
    @SuppressLint("SimpleDateFormat")
    private fun parseDateToMillis(dateString: String): Long? {
        return try {
            val formatter = java.text.SimpleDateFormat("yyyy-MM-dd")
            formatter.parse(dateString)?.time
        } catch (e: Exception) {
            null
        }
    }
}