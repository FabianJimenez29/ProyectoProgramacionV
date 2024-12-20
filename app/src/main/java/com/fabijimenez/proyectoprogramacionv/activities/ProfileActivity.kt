package com.fabijimenez.proyectoprogramacionv.activities

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fabijimenez.proyectoprogramacionv.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfileActivity : AppCompatActivity() {

    private lateinit var databaseReference: DatabaseReference
    private var userUid: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Obtener el UID del intent
        userUid = intent.getStringExtra("USER_UID")

        // Inicializar Firebase Database
        databaseReference = FirebaseDatabase.getInstance().reference

        // Inicializar vistas
        val nombreTextView: TextView = findViewById(R.id.textView3)
        val cedulaTextView: TextView = findViewById(R.id.textView4)
        val telefonoTextView: TextView = findViewById(R.id.textView5)
        val correoTextView: TextView = findViewById(R.id.textView6)
        val provinciaTextView: TextView = findViewById(R.id.textView7)
        val cantonTextView: TextView = findViewById(R.id.textView8)
        val distritoTextView: TextView = findViewById(R.id.textView9)

        // Modificar información
        val modificarInfoText: TextView = findViewById(R.id.textView11)
        modificarInfoText.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            intent.putExtra("USER_UID", userUid)
            startActivity(intent)
        }

        // Cargar datos del usuario
        userUid?.let { uid ->
            databaseReference.child("usuarios").child(uid)
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        nombreTextView.text =
                            "Nombre: ${snapshot.child("nombre").getValue(String::class.java) ?: "N/A"}"
                        cedulaTextView.text =
                            "N Cedula: ${snapshot.child("cedula").getValue(String::class.java) ?: "N/A"}"
                        telefonoTextView.text =
                            "N Telefono: ${snapshot.child("telefono").getValue(String::class.java) ?: "N/A"}"
                        correoTextView.text =
                            "Correo Electronico: ${snapshot.child("correoElectronico").getValue(String::class.java) ?: "N/A"}"
                        provinciaTextView.text =
                            "Provincia: ${snapshot.child("provincia").getValue(String::class.java) ?: "N/A"}"
                        cantonTextView.text =
                            "Canton: ${snapshot.child("canton").getValue(String::class.java) ?: "N/A"}"
                        distritoTextView.text =
                            "Distrito: ${snapshot.child("distrito").getValue(String::class.java) ?: "N/A"}"
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(
                            this@ProfileActivity,
                            "Error al cargar datos: ${error.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
        }

        // Configurar BottomNavigationView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> navigateTo(MainActivity::class.java)
                R.id.nav_store -> navigateTo(ShopActivity::class.java)
                R.id.nav_profile -> navigateTo(ProfileActivity::class.java)
                R.id.nav_branches -> navigateTo(BranchesActivity::class.java)
                R.id.nav_contact -> navigateTo(ContactActivity::class.java)
                else -> false
            }
        }

        // Establecer el ítem seleccionado por defecto
        bottomNavigationView.selectedItemId = R.id.nav_profile
    }

    private fun navigateTo(activityClass: Class<out AppCompatActivity>): Boolean {
        if (javaClass != activityClass) {
            startActivity(Intent(this, activityClass))
            return true
        }
        return false
    }
}
