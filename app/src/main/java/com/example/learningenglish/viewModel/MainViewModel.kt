package com.example.learningenglish.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.learningenglish.data.DataBase
import com.example.learningenglish.data.Entity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val daoLearning = DataBase.getInstance(application).daoLearning()

    val readAllWord: LiveData<List<Entity>> = daoLearning.getAllWordById()

    fun addWord(entity: Entity) = GlobalScope.launch {
        daoLearning.addWord(entity)
    }


    fun deleteWord(entity: Entity) = GlobalScope.launch {
        daoLearning.deleteWord(entity)
    }

    fun updateWord(id: Int,englishVariant: String, russianVariant: String, descriptionAllWord: String) = GlobalScope.launch{
        daoLearning.updateWord(id, englishVariant, russianVariant, descriptionAllWord)
    }

}