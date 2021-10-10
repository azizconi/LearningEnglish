package com.example.learningenglish.ui.dataFragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.learningenglish.R
import com.example.learningenglish.viewModel.MainViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar


class DataFragment : Fragment() {
    private lateinit var russianVersion: EditText

    private lateinit var englishVersion: EditText
    private lateinit var descriptionAll: EditText
    private lateinit var addWord: MaterialButton
    private lateinit var viewModel: MainViewModel

    private lateinit var setRussianVersion: String

    private lateinit var setEnglishVersion: String
    private lateinit var setDescriptionAll: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        russianVersion = view.findViewById(R.id.russianVersion)

        englishVersion = view.findViewById(R.id.englishVersion)
        descriptionAll = view.findViewById(R.id.descriptionAll)
        addWord = view.findViewById(R.id.addWord)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)





        addWord.setOnClickListener {

        }

    }


}