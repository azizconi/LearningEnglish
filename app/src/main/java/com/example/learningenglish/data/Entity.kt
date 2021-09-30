package com.example.learningenglish.data

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity(tableName = "learning")
@Parcelize
data class Entity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @NonNull
    val englishVariant: String,
    @NonNull
    val descriptionEnglishVariant: String,
    val russianVariant: String? = null,
    val descriptionRussianVariant: String? = null
) : Parcelable
