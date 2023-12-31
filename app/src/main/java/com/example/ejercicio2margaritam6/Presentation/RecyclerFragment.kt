package com.example.ejercicio2margaritam6.Presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.ejercicio2margaritam6.R
import com.example.ejercicio2margaritam6.databinding.FragmentRecyclerBinding

class RecyclerFragment : Fragment() {
    lateinit var binding: FragmentRecyclerBinding

    private val itemVM: ViewModelItem by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {


        binding = FragmentRecyclerBinding.inflate(inflater, container, false)

        initAdapter()

        return binding.root
    }

    fun initAdapter() {

        val adapter = Adapter()

        itemVM.getAllItems().observe(viewLifecycleOwner) {
            adapter.setData(it)
            binding.recyclerView.adapter = adapter
            binding.totalAPagarTxt.text = "$ " + adapter.sumarT0tao().toString()

        }
    }
}