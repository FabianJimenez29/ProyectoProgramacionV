package com.fabijimenez.proyectoprogramacionv.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fabijimenez.proyectoprogramacionv.R
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.fabijimenez.proyectoprogramacionv.models.Usuario
import com.google.firebase.database.getValue

class LoginActivity : AppCompatActivity() {
    private lateinit var usuarioEditText: EditText
    private lateinit var contrasenaEditText: EditText
    private lateinit var iniciarSesionButton: Button
    private lateinit var registrarTextView: TextView

    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initializeFirebase()
        initializeViews()
        setupListeners()
    }

    private fun initializeFirebase() {
        FirebaseApp.initializeApp(this)
        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.reference
    }

    private fun initializeViews() {
        usuarioEditText = findViewById(R.id.UsuarioEditText)
        contrasenaEditText = findViewById(R.id.ContraseñaEditText)
        iniciarSesionButton = findViewById(R.id.IniciarSesionButton)
        registrarTextView = findViewById(R.id.tv_registrar)
    }

    private fun setupListeners() {
        iniciarSesionButton.setOnClickListener {
            if (validateLoginInput()) {
                loginUser()
            }
        }

        registrarTextView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validateLoginInput(): Boolean {
        val usuario = usuarioEditText.text.toString().trim()
        val contrasena = contrasenaEditText.text.toString()

        // Clear previous errors
        usuarioEditText.error = null
        contrasenaEditText.error = null

        when {
            usuario.isEmpty() -> {
                usuarioEditText.error = "El usuario es obligatorio"
                return false
            }
            contrasena.isEmpty() -> {
                contrasenaEditText.error = "La contraseña es obligatoria"
                return false
            }
        }

        return true
    }

    private fun loginUser() {
        val usuario = usuarioEditText.text.toString().trim()
        val contrasena = contrasenaEditText.text.toString()

        // Query to find the user
        val query = databaseReference.child("usuarios")
            .orderByChild("usuario")
            .equalTo(usuario)

        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    // Iterate over results (should be only one user)
                    for (userSnapshot in dataSnapshot.children) {
                        val usuarioEncontrado = userSnapshot.getValue<Usuario>()

                        // Verify password
                        if (usuarioEncontrado != null &&
                            usuarioEncontrado.password == contrasena) {

                            // Successful login
                            Toast.makeText(
                                this@LoginActivity,
                                "Inicio de sesión exitoso",
                                Toast.LENGTH_SHORT
                            ).show()

                            // Navigate to main screen
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(intent)
                            finish()

                            return
                        }
                    }
                    // Incorrect password
                    Toast.makeText(
                        this@LoginActivity,
                        "Contraseña incorrecta",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    // User not found
                    Toast.makeText(
                        this@LoginActivity,
                        "Usuario no encontrado",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle query errors
                Toast.makeText(
                    this@LoginActivity,
                    "Error de consulta: ${databaseError.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}