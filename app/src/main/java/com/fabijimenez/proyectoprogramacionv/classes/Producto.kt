package com.fabijimenez.proyectoprogramacionv.classes

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Producto(
    val nombre: String = "",
    val descripcion: String = "",
    val precio: Double = 0.0,
    var imagenUrl: String = ""
) : Parcelable
