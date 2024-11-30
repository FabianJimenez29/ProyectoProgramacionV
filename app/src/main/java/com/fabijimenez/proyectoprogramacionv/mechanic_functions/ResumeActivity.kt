package com.fabijimenez.proyectoprogramacionv.mechanic_functions

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fabijimenez.proyectoprogramacionv.R
import com.fabijimenez.proyectoprogramacionv.activities.BranchesActivity
import com.fabijimenez.proyectoprogramacionv.activities.ContactActivity
import com.fabijimenez.proyectoprogramacionv.activities.MainActivity
import com.fabijimenez.proyectoprogramacionv.activities.ProfileActivity
import com.fabijimenez.proyectoprogramacionv.activities.ShopActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ResumeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resume)




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
    }
}