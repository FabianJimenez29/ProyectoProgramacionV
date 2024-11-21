package com.fabijimenez.proyectoprogramacionv.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fabijimenez.proyectoprogramacionv.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contact)

        val imageButton: ImageButton = findViewById(R.id.imageButton3)

        // Configura el OnClickListener para redirigir a LanguageActivity
        imageButton.setOnClickListener {
            // Crear una intención para iniciar LanguageActivity
            val intent = Intent(this, LanguageActivity::class.java)
            startActivity(intent)
        }

        val spinnerProvincia: Spinner = findViewById(R.id.spinnerProvincia)

        // Definir el array de provincias
        val provincias = arrayOf(
            "Guanacaste", "Heredia", "Alajuela", "San José",
            "Puntarenas", "Cartago", "Limón"
        )

        // Crear un adaptador para el Spinner
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, provincias)

        // Asignar el adaptador al Spinner
        spinnerProvincia.adapter = adapter



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

        // Establecer el ítem seleccionado por defecto
        bottomNavigationView.selectedItemId = R.id.nav_contact
    }
}