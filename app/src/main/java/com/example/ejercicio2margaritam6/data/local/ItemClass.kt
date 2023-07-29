package com.example.ejercicio2margaritam6.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_table")
data class ItemClass(val nombre : String,val precio : Int,val cantidad:Int){
    @PrimaryKey(autoGenerate = true) var id = 0L
}

