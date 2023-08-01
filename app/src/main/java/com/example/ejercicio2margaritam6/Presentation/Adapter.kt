package com.example.ejercicio2margaritam6.Presentation


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicio2margaritam6.data.local.ItemClass
import com.example.ejercicio2margaritam6.databinding.ItemBinding


class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

  // private var items = List<ItemClass> = emptyList()
    private var items: List<ItemClass> = emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        val r = items.size
        Log.e("lol", "binsd: $r")
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemClass = items[position]
        holder.bind(itemClass)
    }

    fun setData(itemClass: List<ItemClass>) {
        this.items = itemClass
    }

    inner class ViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(itemClass: ItemClass) {
            binding.nombreDetalleTxt.text= itemClass.nombre
            binding.precioDetalleTxt.text="$"+ itemClass.precio.toString() +" c/u"
            binding.cantidadDetalleTxt.text="Cantidad " +itemClass.cantidad.toString()
           val r = itemClass.precio * itemClass.cantidad
            binding.resultadoDetalleTxt.text= "$ $r"
            Log.e("lol", "bind: $itemClass.nombre")

        }


    }

}



