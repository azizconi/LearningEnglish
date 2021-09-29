package com.example.learningenglish.data

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "learning")
data class Entity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @NonNull
    val englishVariant: String,
    @NonNull
    val descriptionEnglishVariant: String,
    val russianVariant: String? = null,
    val descriptionRussianVariant: String? = null
)
