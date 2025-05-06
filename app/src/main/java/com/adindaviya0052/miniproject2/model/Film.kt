package com.adindaviya0052.miniproject2.model

data class Film(
    val id: Long,
    val judul: String,
    val review: String,
    val kategori: String,
    val status: String,
    val tanggal: Long?
)
