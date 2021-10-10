package com.example.learningenglish.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Entity::class], version = 4)
abstract class DataBase : RoomDatabase() {

    abstract fun daoLearning(): DaoLearning

    companion object {

        private var INSTANCE: DataBase? = null
        fun getInstance(context: Context): DataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DataBase::class.java,
                        "learning"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return instance
            }
        }
    }

}
