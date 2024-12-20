package com.fabijimenez.proyectoprogramacionv.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.fabijimenez.proyectoprogramacionv.R
import com.fabijimenez.proyectoprogramacionv.mechanic_functions.ScheduleRepair
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {
    private var userUid: String? = null
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Inicializar Firebase
        databaseReference = FirebaseDatabase.getInstance().reference

        // Obtener el UID del intent
        userUid = intent.getStringExtra("USER_UID")

        // Cargar y mostrar el nombre del usuario
        loadUserName()

        val imageButton: ImageButton = findViewById(R.id.imageButton3)
        imageButton.setOnClickListener {
            val intent = Intent(this, LanguageActivity::class.java)
            intent.putExtra("USER_UID", userUid)
            startActivity(intent)
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    if (javaClass != MainActivity::class.java) {
                        val intent = Intent(this, MainActivity::class.java)
                        intent.putExtra("USER_UID", userUid)
                        startActivity(intent)
                    }
                    true
                }
                R.id.nav_store -> {
                    if (javaClass != ShopActivity::class.java) {
                        val intent = Intent(this, ShopActivity::class.java)
                        intent.putExtra("USER_UID", userUid)
                        startActivity(intent)
                    }
                    true
                }
                R.id.nav_profile -> {
                    if (javaClass != ProfileActivity::class.java) {
                        val intent = Intent(this, ProfileActivity::class.java)
                        intent.putExtra("USER_UID", userUid)
                        startActivity(intent)
                    }
                    true
                }
                R.id.nav_branches -> {
                    if (javaClass != BranchesActivity::class.java) {
                        val intent = Intent(this, BranchesActivity::class.java)
                        intent.putExtra("USER_UID", userUid)
                        startActivity(intent)
                    }
                    true
                }
                R.id.nav_contact -> {
                    if (javaClass != ContactActivity::class.java) {
                        val intent = Intent(this, ContactActivity::class.java)
                        intent.putExtra("USER_UID", userUid)
                        startActivity(intent)
                    }
                    true
                }
                else -> false
            }
        }

        bottomNavigationView.selectedItemId = R.id.nav_home

        val scheduleRepairBTN: Button = findViewById(R.id.scheduleRepairBTN)
        scheduleRepairBTN.setOnClickListener {
            val intent = Intent(this, ScheduleRepair::class.java)
            intent.putExtra("USER_UID", userUid)
            startActivity(intent)
        }

        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            // Aquí puedes agregar la navegación a la actividad de estado de reparación
            Toast.makeText(this, "Función en desarrollo", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadUserName() {
        val userNameTextView = findViewById<TextView>(R.id.userNameTextView)

        userUid?.let { uid ->
            databaseReference.child("usuarios").child(uid)
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val nombre = snapshot.child("nombre").getValue(String::class.java)
                        userNameTextView.text = "¡Bienvenido, $nombre!"
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(
                            this@MainActivity,
                            "Error al cargar el nombre: ${error.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
        }
    }
}