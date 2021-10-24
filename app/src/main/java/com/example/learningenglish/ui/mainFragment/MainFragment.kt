package com.example.learningenglish.ui.mainFragment

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learningenglish.R
import com.example.learningenglish.data.Entity
import com.example.learningenglish.ui.recyclerView.AdapterRecyclerView
import com.example.learningenglish.utils.OnClick
import com.example.learningenglish.utils.OnLongClick
import com.example.learningenglish.viewModel.MainViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainFragment : Fragment(), OnClick, OnLongClick {

    private lateinit var viewModel: MainViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var adapterRecyclerView: AdapterRecyclerView
    lateinit var floatActionButton: FloatingActionButton


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        recyclerView = view.findViewById(R.id.recyclerMain)
        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        adapterRecyclerView = AdapterRecyclerView(this, this)
        recyclerView.adapter = adapterRecyclerView


        viewModel.readAllWord.observe(viewLifecycleOwner) {
            adapterRecyclerView.setData(it)
        }


        floatActionButton = view.findViewById(R.id.floatActionButton)


        floatActionButton.setOnClickListener {
            floatActionButton.findNavController().navigate(R.id.dataFragment)
        }


    }

    override fun onClickList(entity: Entity) {

        val bundle: Bundle = Bundle()
        bundle.putParcelable("entity", entity)
        findNavController().navigate(R.id.dataFragment, bundle)
    }

    override fun onLongClickList(entity: Entity) {
        showWindowForDelete(entity)
    }


    private fun showWindowForDelete(entity: Entity) {
        val mAlertDialog = AlertDialog.Builder(requireContext())

        mAlertDialog.setTitle("Удаление") //set alertdialog title
        mAlertDialog.setMessage("Вы точно хотети удалить слово?")
        mAlertDialog.setPositiveButton("Да") { dialog, id ->
            viewModel.deleteWord(entity)
        }
        mAlertDialog.setNegativeButton("Нет") { dialog, id ->
            dialog.cancel()
        }
        mAlertDialog.show()

    }


}