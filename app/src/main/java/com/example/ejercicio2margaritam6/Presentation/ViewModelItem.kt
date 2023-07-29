package com.example.ejercicio2margaritam6.Presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.ejercicio2margaritam6.data.Repository
import com.example.ejercicio2margaritam6.data.local.ItemClass
import com.example.ejercicio2margaritam6.data.local.ItemDB
import kotlinx.coroutines.launch


class ViewModelItem (application: Application) : AndroidViewModel(application) {
    private val repository: Repository

    init {
        val dao = ItemDB.getDatabase(application).getDaoItem()
        repository = Repository(dao)
    }

    fun getAllItems(): LiveData<MutableList<ItemClass>> = repository.getItem()

    fun insertItem(nombre: String, precio: Int, cantidad: Int) = viewModelScope.launch {
        val item = ItemClass(nombre, precio, cantidad)
        repository.insertItem(item)
    }
}