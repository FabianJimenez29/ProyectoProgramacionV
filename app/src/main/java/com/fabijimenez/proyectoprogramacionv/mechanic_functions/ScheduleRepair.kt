package com.fabijimenez.proyectoprogramacionv.mechanic_functions


import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.fabijimenez.proyectoprogramacionv.R
import com.fabijimenez.proyectoprogramacionv.activities.MainActivity
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAdjusters

class ScheduleRepair : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_schedule_repair)


        val spinnerSucursal: Spinner = findViewById(R.id.spinnerSucursal)

        // Definir el array de provincias
        val sucursales = arrayOf(
            "Liberia", "Alajuela", "Cartago", "Heredia",
            "Santa Ana", "Anonos", "Avenida 10", "San Sebastian",
            "Escazu", "Guapiles", "Mango Plaza", "San Isidro D. G",
            "Curridabat"
        )

        // Crear un adaptador para el Spinner
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, sucursales)

        // Asignar el adaptador al Spinner
        spinnerSucursal.adapter = adapter





        val spinnerServicio: Spinner = findViewById(R.id.spinnerServicio)

        // Definir el array de provincias
        val servicios = arrayOf(
            "Alineado De Direccion", "Alineado De Luces", "Balanceo De Llantas", "Rotacion De Llantas",
            "Cambio De Aceite Del Motor"
        )

        // Crear un adaptador para el Spinner
        val adapta = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, servicios)

        // Asignar el adaptador al Spinner
        spinnerServicio.adapter = adapta




        val spinnerFecha: Spinner = findViewById(R.id.spinnerFecha)
        val today = LocalDate.now()
        val startOfWeek = today.with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY))
        val endOfWeek = today.with(TemporalAdjusters.nextOrSame(java.time.DayOfWeek.SATURDAY))

        val fechas = mutableListOf<String>()
        val formatter = DateTimeFormatter.ofPattern("EEEE, d 'de' MMMM")

        var currentDate = startOfWeek
        while (!currentDate.isAfter(endOfWeek)) {
            fechas.add(currentDate.format(formatter))
            currentDate = currentDate.plusDays(1)
        }

        val adapterFecha = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, fechas)
        spinnerFecha.adapter = adapterFecha

        // Configurar el Spinner para las horas
        val spinnerHora: Spinner = findViewById(R.id.spinnerHora)
        val horas = listOf("8:00 AM", "11:00 AM", "1:00 PM", "3:00 PM")

        val adapterHora = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, horas)
        spinnerHora.adapter = adapterHora



        val Back: ImageView = findViewById(R.id.arrowBack)
        Back.setOnClickListener {
            // Crear un Intent para abrir ScheduleRepair
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



        val buttonIncreible: Button = findViewById(R.id.button7)

        // Configura el listener
        buttonIncreible.setOnClickListener {
            startActivity(Intent(this, ScheduleRepair3::class.java))
        }
    }
}