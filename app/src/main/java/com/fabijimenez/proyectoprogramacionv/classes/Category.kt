package com.fabijimenez.proyectoprogramacionv.classes

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val name: String = "",
    val imageResourceId: Int = 0
) : Parcelable
