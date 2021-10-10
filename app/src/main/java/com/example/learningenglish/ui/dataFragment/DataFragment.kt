package com.example.learningenglish.ui.dataFragment

import android.R.attr
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
import com.example.learningenglish.data.Entity
import com.example.learningenglish.viewModel.MainViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_data.*
import android.R.attr.description





class DataFragment : Fragment() {
    private lateinit var russianVersion: EditText
    private lateinit var englishVersion: EditText

    private lateinit var descriptionAll: EditText

    private lateinit var addWord: MaterialButton
    private lateinit var viewModel: MainViewModel
    lateinit var entity: Entity


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


        if (arguments?.getParcelable<Entity>("entity") != null) {
            entity = requireArguments().getParcelable<Entity>("entity")!!

            entity.englishVariant.let {
                englishVersion.setText(it)
            }

            entity.russianVariant.let {
                russianVersion.setText(it)
            }

            entity.descriptionAllWord.let {
                descriptionAll.setText(it)
            }

            addWord.text = "Update"

            addWord.setOnClickListener {

                viewModel.addWord(entity = entity)

            }

        }

        addWord.setOnClickListener {
            if(TextUtils.isEmpty(getRussianVersion()) && TextUtils.isEmpty(getEnglishVersion())){
                Toast.makeText(requireContext(), "Заполните поля", Toast.LENGTH_SHORT)
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

    private fun getDescriptionAll(): String {
        return descriptionAll.text.toString().trim()
    }

}


