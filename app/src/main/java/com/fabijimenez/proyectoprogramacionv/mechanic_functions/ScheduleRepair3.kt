package com.fabijimenez.proyectoprogramacionv.mechanic_functions

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.fabijimenez.proyectoprogramacionv.R

class ScheduleRepair3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_repair3)



        val spinnerSucursal: Spinner = findViewById(R.id.spinnerSucursal)

        // Definir el array de provincias
        val sucursales = arrayOf(
            "Carga Liviana CL", "Carga Pesada CP", "Motos MO", "Vehiculo Gobierno PE",

        )

        // Crear un adaptador para el Spinner
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, sucursales)

        // Asignar el adaptador al Spinner
        spinnerSucursal.adapter = adapter


        val utton = findViewById<Button>(R.id.button8)

        // Configura el listener
        utton.setOnClickListener {
            startActivity(Intent(this, ResumeActivity::class.java))
        }
    }
}