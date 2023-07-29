package com.example.ejercicio2margaritam6.data

import androidx.lifecycle.LiveData
import com.example.ejercicio2margaritam6.data.local.DaoItem
import com.example.ejercicio2margaritam6.data.local.ItemClass

class Repository(private val daoItem: DaoItem) {

    suspend fun insertItem(itemClass: ItemClass) {

        daoItem.insertarItem(itemClass)

    }

    fun getItem():
            LiveData<MutableList<ItemClass>> {
return daoItem.showItem()

    }

}
