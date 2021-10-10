package com.example.learningenglish.data

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity(tableName = "learning")
@Parcelize
data class Entity(
    @NonNull
    val englishVariant: String,
    @NonNull
    val russianVariant: String? = null,
    val descriptionAllWord: String? = null
) : Parcelable{
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
