package com.example.ejercicio2margaritam6.Presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.ejercicio2margaritam6.R
import com.example.ejercicio2margaritam6.databinding.FragmentIngresoConsumoBinding

class IngresoConsumoFragment : Fragment() {

lateinit var binding : FragmentIngresoConsumoBinding
private val itemVM : ViewModelItem by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIngresoConsumoBinding .inflate(layoutInflater, container, false)
        initListener()

        return binding.root
    }
    private fun initListener() {


        binding.agregarB.setOnClickListener {
            val nombre = binding.nombreEdit.text.toString()
            val precio = binding.precioEdit.text.toString().toInt()
            val cantidad = binding.cantidadEdit.text.toString().toInt()

            saveTarea(nombre,precio,cantidad)

            val r = precio * cantidad
            binding.resultadoTxt.text=r.toString()
        }
        binding.listarItemB.setOnClickListener {
            findNavController().navigate(R.id.action_ingresoConsumoFragment_to_recyclerFragment)
        }
    }

    private fun saveTarea(nombre: String,precio : Int, cantidad: Int) {

        itemVM.insertItem(nombre,precio,cantidad)

    }


}