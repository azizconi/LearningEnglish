package com.example.learningenglish.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface DaoLearning {

    @Insert
    fun addWord(entity: Entity)

    @Query("select * from learning order by id desc")
    fun getAllWordById() : LiveData<List<Entity>>

    @Delete
    fun deleteWord(entity: Entity)

}