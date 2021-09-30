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
    private lateinit var descriptionRussian: EditText
    private lateinit var englishVersion: EditText
    private lateinit var descriptionEnglish: EditText
    private lateinit var addWord: MaterialButton
    private lateinit var viewModel: MainViewModel

    private lateinit var setRussianVersion: String
    private lateinit var setDescriptionRussian: String
    private lateinit var setEnglishVersion: String
    private lateinit var setDescriptionEnglish: String

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
        descriptionRussian = view.findViewById(R.id.descriptionRussian)
        englishVersion = view.findViewById(R.id.englishVersion)
        descriptionEnglish = view.findViewById(R.id.descriptionEnglish)
        addWord = view.findViewById(R.id.addWord)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        russianVersion.setText(setRussianVersion)
        descriptionRussian.setText(setDescriptionRussian)
        englishVersion.setText(setEnglishVersion)
        descriptionEnglish.setText(setDescriptionEnglish)


        addWord.setOnClickListener {
            if (!TextUtils.isEmpty(getRussianVersion()) && !TextUtils.isEmpty(getEnglishVersion())) {
                Toast.makeText(requireContext(), "Поля заполнены", Toast.LENGTH_SHORT)
                    .show()
            }else{
                Toast.makeText(requireContext(), "Сначала заполните поля", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }

    private fun getRussianVersion(): String {
        return russianVersion.text.toString().trim()
    }

    private fun getEnglishVersion(): String {
        return englishVersion.text.toString().trim()
    }
}