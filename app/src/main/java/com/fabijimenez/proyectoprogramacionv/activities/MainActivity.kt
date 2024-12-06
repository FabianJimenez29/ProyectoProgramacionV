package com.fabijimenez.proyectoprogramacionv.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.fabijimenez.proyectoprogramacionv.R
import com.fabijimenez.proyectoprogramacionv.mechanic_functions.ScheduleRepair
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val imageButton: ImageButton = findViewById(R.id.imageButton3)

        // Configura el OnClickListener para redirigir a LanguageActivity
        imageButton.setOnClickListener {
            // Crear una intención para iniciar LanguageActivity
            val intent = Intent(this, LanguageActivity::class.java)
            startActivity(intent)
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Solo navega si la actividad actual no es la misma
                    if (javaClass != MainActivity::class.java) {
                        startActivity(Intent(this, MainActivity::class.java))
                    }
                    true
                }
                R.id.nav_store -> {
                    // Solo navega si la actividad actual no es la misma
                    if (javaClass != ShopActivity::class.java) {
                        startActivity(Intent(this, ShopActivity::class.java))
                    }
                    true
                }
                R.id.nav_profile -> {
                    // Solo navega si la actividad actual no es la misma
                    if (javaClass != ProfileActivity::class.java) {
                        startActivity(Intent(this, ProfileActivity::class.java))
                    }
                    true
                }
                R.id.nav_branches -> {
                    // Solo navega si la actividad actual no es la misma
                    if (javaClass != BranchesActivity::class.java) {
                        startActivity(Intent(this, BranchesActivity::class.java))
                    }
                    true
                }
                R.id.nav_contact -> {
                    // Solo navega si la actividad actual no es la misma
                    if (javaClass != ContactActivity::class.java) {
                        startActivity(Intent(this, ContactActivity::class.java))
                    }
                    true
                }
                else -> false
            }
        }

        //Hola

        // Establecer el ítem seleccionado por defecto
        bottomNavigationView.selectedItemId = R.id.nav_home


        val scheduleRepairBTN: Button = findViewById(R.id.scheduleRepairBTN)
        scheduleRepairBTN.setOnClickListener {
            // Crear un Intent para abrir ScheduleRepair
            val intent = Intent(this, ScheduleRepair::class.java)
            startActivity(intent)
        }
    }



}
