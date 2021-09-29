package com.example.learningenglish.ui.mainFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learningenglish.R
import com.example.learningenglish.data.Entity
import com.example.learningenglish.ui.recyclerView.AdapterRecyclerView
import com.example.learningenglish.utils.OnClick
import com.example.learningenglish.viewModel.MainViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainFragment : Fragment(), OnClick {

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
        adapterRecyclerView = AdapterRecyclerView(this)
        recyclerView.adapter = adapterRecyclerView


        viewModel.readAllWord.observe(viewLifecycleOwner) { entity ->
            adapterRecyclerView.setData(entity)
        }


        floatActionButton = view.findViewById(R.id.floatActionButton)


        floatActionButton.setOnClickListener {
            floatActionButton.findNavController().navigate(R.id.dataFragment)
        }


    }

    override fun onClickList(entity: Entity) {

    }


}