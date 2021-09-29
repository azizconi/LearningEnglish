package com.example.learningenglish.ui.dataFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.learningenglish.R


class DataFragment : Fragment() {
    private lateinit var russianVersion: EditText
    private lateinit var descriptionRussian: EditText
    private lateinit var englishVersion: EditText
    private lateinit var descriptionEnglish: EditText


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




    }
}