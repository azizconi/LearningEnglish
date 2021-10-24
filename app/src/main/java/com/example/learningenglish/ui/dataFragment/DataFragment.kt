package com.example.learningenglish.ui.dataFragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.learningenglish.R
import com.example.learningenglish.data.Entity
import com.example.learningenglish.viewModel.MainViewModel
import com.google.android.material.button.MaterialButton
import androidx.navigation.NavOptions





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


    @SuppressLint("RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        englishVersion = view.findViewById(R.id.englishVersion)
        russianVersion = view.findViewById(R.id.russianVersion)
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
            }




        addWord.setOnClickListener {
            if (
                !TextUtils.isEmpty(getRussianVersion()) &&
                !TextUtils.isEmpty(getEnglishVersion()) ||
                !TextUtils.isEmpty(getDescriptionAll())
            ) {
                if (arguments?.getParcelable<Entity>("entity") != null) {
                    entity = requireArguments().getParcelable<Entity>("entity")!!





                    viewModel.updateWord(
                        id = 1,
                        englishVariant = getEnglishVersion(),
                        russianVariant = getRussianVersion(),
                        descriptionAllWord = getDescriptionAll()
                    )



                    addWord.findNavController()
                        .navigate(R.id.mainFragment)



                    Log.e("TAG", "onViewCreated: кор кад")
                } else {
                    entity = Entity(getEnglishVersion(), getRussianVersion(), getDescriptionAll())
                    viewModel.addWord(entity = entity)
                    addWord.findNavController().navigate(R.id.mainFragment)
                }
            } else {
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


