package com.fabijimenez.proyectoprogramacionv.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fabijimenez.proyectoprogramacionv.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class LanguageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_language)



        // Obtener los botones
        val btnSpanish: Button = findViewById(R.id.btnSpanish)
        val btnEnglish: Button = findViewById(R.id.btnEnglish)
        val btnFrench: Button = findViewById(R.id.btnFrench)
        val btnItalian: Button = findViewById(R.id.btnItalian)
        val btnConfirm: Button = findViewById(R.id.btnConfirm)

        // Configurar los listeners para los botones
        btnSpanish.setOnClickListener {
            showToast("Seleccionaste Español")
        }

        btnEnglish.setOnClickListener {
            showToast("Seleccionaste Inglés")
        }

        btnFrench.setOnClickListener {
            showToast("Seleccionaste Francés")
        }

        btnItalian.setOnClickListener {
            showToast("Seleccionaste Italiano")
        }

        btnConfirm.setOnClickListener {
            showToast("Idioma seleccionado!")
            // Aquí podrías agregar lógica para cambiar el idioma de la aplicación
        }

        val confirm = findViewById<Button>(R.id.btnConfirm)
        confirm.setOnClickListener {
            // Crear una intención para iniciar LanguageActivity
            val intent = Intent(this, MainActivity::class.java)
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

        // Establecer el ítem seleccionado por defecto
        bottomNavigationView.selectedItemId = 0
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}