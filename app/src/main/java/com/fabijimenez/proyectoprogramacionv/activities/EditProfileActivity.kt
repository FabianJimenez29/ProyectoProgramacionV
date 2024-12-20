package com.fabijimenez.proyectoprogramacionv.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fabijimenez.proyectoprogramacionv.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class EditProfileActivity : AppCompatActivity() {
    private lateinit var databaseReference: DatabaseReference
    private var userUid: String? = null

    private lateinit var nombreEditText: EditText
    private lateinit var cedulaEditText: EditText
    private lateinit var telefonoEditText: EditText
    private lateinit var correoEditText: EditText
    private lateinit var provinciaEditText: EditText
    private lateinit var cantonEditText: EditText
    private lateinit var distritoEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        // Obtener el UID del usuario
        userUid = intent.getStringExtra("USER_UID")

        // Inicializar Firebase
        databaseReference = FirebaseDatabase.getInstance().reference

        // Inicializar vistas
        nombreEditText = findViewById(R.id.editTextNombre)
        cedulaEditText = findViewById(R.id.editTextCedula)
        telefonoEditText = findViewById(R.id.editTextTelefono)
        correoEditText = findViewById(R.id.editTextCorreo)
        provinciaEditText = findViewById(R.id.editTextProvincia)
        cantonEditText = findViewById(R.id.editTextCanton)
        distritoEditText = findViewById(R.id.editTextDistrito)

        // Configurar botón de regreso
        val btnRegresar = findViewById<ImageButton>(R.id.btnRegresar)
        btnRegresar.setOnClickListener {
            onBackPressed()
        }

        // Configurar botón de guardar
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        btnGuardar.setOnClickListener {
            guardarCambios()
        }

        // Cargar datos actuales
        cargarDatosActuales()
    }

    private fun cargarDatosActuales() {
        userUid?.let { uid ->
            databaseReference.child("usuarios").child(uid)
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        nombreEditText.setText(snapshot.child("nombre").getValue(String::class.java))
                        cedulaEditText.setText(snapshot.child("cedula").getValue(String::class.java))
                        telefonoEditText.setText(snapshot.child("telefono").getValue(String::class.java))
                        correoEditText.setText(snapshot.child("correoElectronico").getValue(String::class.java))
                        provinciaEditText.setText(snapshot.child("provincia").getValue(String::class.java))
                        cantonEditText.setText(snapshot.child("canton").getValue(String::class.java))
                        distritoEditText.setText(snapshot.child("distrito").getValue(String::class.java))
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(this@EditProfileActivity,
                            "Error al cargar datos: ${error.message}",
                            Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }

    private fun guardarCambios() {
        if (!validarCampos()) return

        val updates = hashMapOf<String, Any>(
            "nombre" to nombreEditText.text.toString().trim(),
            "cedula" to cedulaEditText.text.toString().trim(),
            "telefono" to telefonoEditText.text.toString().trim(),
            "correoElectronico" to correoEditText.text.toString().trim(),
            "provincia" to provinciaEditText.text.toString().trim(),
            "canton" to cantonEditText.text.toString().trim(),
            "distrito" to distritoEditText.text.toString().trim()
        )

        userUid?.let { uid ->
            databaseReference.child("usuarios").child(uid)
                .updateChildren(updates)
                .addOnSuccessListener {
                    Toast.makeText(this, "Datos actualizados exitosamente", Toast.LENGTH_SHORT).show()
                    onBackPressed() // Regresar a la pantalla anterior
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Error al actualizar: ${e.message}", Toast.LENGTH_SHORT).show()
                }
        } ?: run {
            Toast.makeText(this, "Error: No se encontró el ID de usuario", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validarCampos(): Boolean {
        var isValid = true

        if (nombreEditText.text.toString().trim().isEmpty()) {
            nombreEditText.error = "Campo requerido"
            isValid = false
        }
        if (cedulaEditText.text.toString().trim().isEmpty()) {
            cedulaEditText.error = "Campo requerido"
            isValid = false
        }
        if (telefonoEditText.text.toString().trim().isEmpty()) {
            telefonoEditText.error = "Campo requerido"
            isValid = false
        }
        if (correoEditText.text.toString().trim().isEmpty()) {
            correoEditText.error = "Campo requerido"
            isValid = false
        }
        if (provinciaEditText.text.toString().trim().isEmpty()) {
            provinciaEditText.error = "Campo requerido"
            isValid = false
        }
        if (cantonEditText.text.toString().trim().isEmpty()) {
            cantonEditText.error = "Campo requerido"
            isValid = false
        }
        if (distritoEditText.text.toString().trim().isEmpty()) {
            distritoEditText.error = "Campo requerido"
            isValid = false
        }

        return isValid
    }
}