package com.adindaviya0052.miniproject2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "film")
data class Film(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val judul: String,
    val review: String,
    val kategori: String,
    val status: String,
    val tanggal: Long?
)
