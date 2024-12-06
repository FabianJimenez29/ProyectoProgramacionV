package com.fabijimenez.proyectoprogramacionv.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fabijimenez.proyectoprogramacionv.R
import com.fabijimenez.proyectoprogramacionv.models.Usuario
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    // UI Components
    private lateinit var usuarioEditText: EditText
    private lateinit var nombreEditText: EditText
    private lateinit var correoElectronicoEditText: EditText
    private lateinit var contrasenaEditText: EditText
    private lateinit var cedulaEditText: EditText
    private lateinit var telefonoEditText: EditText
    private lateinit var cantonEditText: EditText
    private lateinit var distritoEditText: EditText
    private lateinit var provinciaSpinner: Spinner
    private lateinit var registrarButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register)

        initializeFirebase()
        initializeViews()
        setupProvinciaSpinner()

        registrarButton.setOnClickListener {
            if (validateAndSaveData()) {
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun initializeFirebase() {
        FirebaseApp.initializeApp(this)
        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.reference
    }

    private fun initializeViews() {
        usuarioEditText = findViewById(R.id.usuarioEditText)
        nombreEditText = findViewById(R.id.nombreEditText)
        correoElectronicoEditText = findViewById(R.id.correoElectronicoEditText)
        contrasenaEditText = findViewById(R.id.contrasenaEditText)
        cedulaEditText = findViewById(R.id.cedulaEditText)
        telefonoEditText = findViewById(R.id.telefonoEditText)
        cantonEditText = findViewById(R.id.CantonEditText)
        distritoEditText = findViewById(R.id.DistritoEditText)
        provinciaSpinner = findViewById(R.id.provinciaSpinner)
        registrarButton = findViewById(R.id.registrarButton)
    }

    private fun setupProvinciaSpinner() {
        val provincias = arrayListOf(
            "Seleccione una provincia",
            "San José", "Alajuela", "Cartago", "Heredia",
            "Guanacaste", "Puntarenas", "Limón"
        )

        val adapter = object : ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_item,
            provincias
        ) {
            override fun isEnabled(position: Int): Boolean {
                return position != 0
            }

            override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getDropDownView(position, convertView, parent)
                val tv = view as TextView
                tv.setTextColor(if (position == 0) Color.GRAY else Color.BLACK)
                return view
            }
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        provinciaSpinner.adapter = adapter
    }

    private fun clearAllFields() {
        usuarioEditText.text.clear()
        nombreEditText.text.clear()
        correoElectronicoEditText.text.clear()
        contrasenaEditText.text.clear()
        cedulaEditText.text.clear()
        telefonoEditText.text.clear()
        cantonEditText.text.clear()
        distritoEditText.text.clear()
        provinciaSpinner.setSelection(0)
    }

    private fun validateAndSaveData(): Boolean {
        // Clear previous errors
        listOf(
            usuarioEditText, nombreEditText, correoElectronicoEditText,
            contrasenaEditText, cedulaEditText, telefonoEditText,
            cantonEditText, distritoEditText
        ).forEach { it.error = null }

        // Get values
        val usuario = usuarioEditText.text.toString().trim()
        val nombre = nombreEditText.text.toString().trim()
        val correo = correoElectronicoEditText.text.toString().trim()
        val password = contrasenaEditText.text.toString()
        val cedula = cedulaEditText.text.toString().trim()
        val telefono = telefonoEditText.text.toString().trim()
        val canton = cantonEditText.text.toString().trim()
        val distrito = distritoEditText.text.toString().trim()
        val provincia = provinciaSpinner.selectedItem.toString()

        var isValid = true

        // Validation checks
        when {
            usuario.isEmpty() -> {
                usuarioEditText.error = "El usuario es obligatorio"
                isValid = false
            }
            usuario.length < 3 -> {
                usuarioEditText.error = "El usuario debe tener al menos 3 caracteres"
                isValid = false
            }
        }

        when {
            nombre.isEmpty() -> {
                nombreEditText.error = "El nombre es obligatorio"
                isValid = false
            }
        }

        when {
            correo.isEmpty() -> {
                correoElectronicoEditText.error = "El correo electrónico es obligatorio"
                isValid = false
            }
            !isValidEmail(correo) -> {
                correoElectronicoEditText.error = "Correo electrónico inválido"
                isValid = false
            }
        }

        when {
            password.isEmpty() -> {
                contrasenaEditText.error = "La contraseña es obligatoria"
                isValid = false
            }
            password.length < 6 -> {
                contrasenaEditText.error = "La contraseña debe tener al menos 6 caracteres"
                isValid = false
            }
        }

        when {
            cedula.isEmpty() -> {
                cedulaEditText.error = "La cédula es obligatoria"
                isValid = false
            }
            !isValidCedula(cedula) -> {
                cedulaEditText.error = "Cédula inválida"
                isValid = false
            }
        }

        when {
            telefono.isEmpty() -> {
                telefonoEditText.error = "El teléfono es obligatorio"
                isValid = false
            }
            !isValidTelefono(telefono) -> {
                telefonoEditText.error = "Teléfono inválido"
                isValid = false
            }
        }

        when {
            canton.isEmpty() -> {
                cantonEditText.error = "El cantón es obligatorio"
                isValid = false
            }
        }

        when {
            distrito.isEmpty() -> {
                distritoEditText.error = "El distrito es obligatorio"
                isValid = false
            }
        }

        when {
            provincia == "Seleccione una provincia" -> {
                Toast.makeText(this, "Debe seleccionar una provincia", Toast.LENGTH_SHORT).show()
                isValid = false
            }
        }

        if (isValid) {
            val userData = mapOf(
                "usuario" to usuario,
                "nombre" to nombre,
                "correo" to correo,
                "cedula" to cedula,
                "telefono" to telefono,
                "canton" to canton,
                "distrito" to distrito,
                "provincia" to provincia,
                "password" to password
            )

            saveUserData(userData)
            clearAllFields()
        }

        return isValid
    }

    private fun isValidEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
        return Pattern.compile(emailRegex).matcher(email).matches()
    }

    private fun isValidCedula(cedula: String): Boolean {
        return cedula.length == 9 && cedula.all { it.isDigit() }
    }

    private fun isValidTelefono(telefono: String): Boolean {
        return telefono.length == 8 && telefono.all { it.isDigit() }
    }

    private fun saveUserData(userData: Map<String, String>) {
        val nuevoUsuario = Usuario().apply {
            usuario = userData["usuario"]!!
            nombre = userData["nombre"]!!
            correoElectronico = userData["correo"]!!
            cedula = userData["cedula"]!!
            telefono = userData["telefono"]!!
            canton = userData["canton"]!!
            distrito = userData["distrito"]!!
            provincia = userData["provincia"]!!
            password = userData["password"]!!
        }

        val userId = databaseReference.child("usuarios").push().key

        userId?.let {
            nuevoUsuario.uid = it

            databaseReference.child("usuarios").child(it).setValue(nuevoUsuario)
                .addOnSuccessListener {
                    Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Error al registrar usuario: ${e.message}", Toast.LENGTH_SHORT).show()
                }
        }
    }
}