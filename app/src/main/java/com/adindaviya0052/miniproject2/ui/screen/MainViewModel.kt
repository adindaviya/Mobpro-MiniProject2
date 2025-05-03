package com.adindaviya0052.miniproject2.ui.screen

import androidx.lifecycle.ViewModel
import com.adindaviya0052.miniproject2.model.Film

class MainViewModel : ViewModel() {

    val data = listOf(
        Film(
            1,
            "Mendadak dangdut",
            "Lucuu banget keanu",
            "Film Indonesia",
            "Sudah ditonton",
            "2025-04-30"
        ),
        Film(
            2,
            "True beauty",
            "Mengajarkan kita untuk tidak insecure, Cha Eun Woo ganteng",
            "Drama Korea",
            "Sudah ditonton",
            "2025-05-01"
        ),
        Film(
            3,
            "Memory of encaustic tile",
            "Kerenn, baru episode awal sudah menarik",
            "Drama China",
            "Sedang ditonton",
            "2025-05-02"
        ),
        Film(
            4,
            "Jumbo",
            "Film animasi bestt",
            "Film Animasi",
            "Belum ditonton",
            "2025-05-03"
        ),
        Film(
            5,
            "Enola holmes",
            "Best aku suka film barat detektif seperti ini",
            "Film Hollywood",
            "Sudah ditonton",
            "2025-05-03"
        ),
    )
}