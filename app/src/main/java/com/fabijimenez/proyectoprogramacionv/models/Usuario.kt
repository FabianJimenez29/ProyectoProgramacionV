package com.fabijimenez.proyectoprogramacionv.models

class Usuario {
    var uid: String? = null
    var usuario: String? = null
    lateinit var nombre: String
    var correoElectronico: String? = null
    var password: String? = null
    var cedula: String? = null
    var telefono: String? = null
    var provincia: String? = null
    var canton: String? = null
    var distrito: String? = null

    constructor()

    override fun toString(): String = nombre
}