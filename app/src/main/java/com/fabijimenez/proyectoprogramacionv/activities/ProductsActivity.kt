package com.fabijimenez.proyectoprogramacionv.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fabijimenez.proyectoprogramacionv.R
import com.fabijimenez.proyectoprogramacionv.adapters.ProductAdapter
import com.fabijimenez.proyectoprogramacionv.classes.Category
import com.fabijimenez.proyectoprogramacionv.classes.Producto
import com.google.firebase.appcheck.ktx.appCheck
import com.google.firebase.appcheck.playintegrity.PlayIntegrityAppCheckProviderFactory
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage

class ProductsActivity : AppCompatActivity() {
    private lateinit var recyclerViewProducts: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private val productos = mutableListOf<Producto>()
    private val TAG = "ProductsActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        // Inicializar Firebase App Check con Play Integrity
        Firebase.appCheck.installAppCheckProviderFactory(
            PlayIntegrityAppCheckProviderFactory.getInstance()
        )

        // Recuperar la categoría pasada desde ShopActivity
        val category = intent.getParcelableExtra<Category>("category")

        category?.let {
            supportActionBar?.title = it.name

            // Configurar RecyclerView
            recyclerViewProducts = findViewById(R.id.recyclerViewProducts)
            recyclerViewProducts.layoutManager = GridLayoutManager(this, 2)

            // Obtener los productos de la categoría desde Firebase
            getProductsForCategory(category)
        }
    }

    private fun getProductsForCategory(category: Category?) {
        if (category == null) {
            Toast.makeText(this, "Categoría no seleccionada", Toast.LENGTH_SHORT).show()
            return
        }

        val db = FirebaseFirestore.getInstance()
        db.collection("productos")
            .whereEqualTo("categoria.name", category.name) // Filtrar por la categoría
            .get()
            .addOnSuccessListener { querySnapshot ->
                Log.d(TAG, "Productos encontrados: ${querySnapshot.size()}")
                productos.clear()
                for (document in querySnapshot.documents) {
                    val producto = document.toObject(Producto::class.java)
                    producto?.let {
                        Log.d(TAG, "Cargando producto: ${it.nombre}")
                        // Add a method to load image URL for each producto
                        loadProductImage(it)
                        productos.add(it)
                    }
                }

                // Configurar el adaptador
                productAdapter = ProductAdapter(productos) { producto ->
                    // Manejar clic en producto (opcional)
                    Toast.makeText(this, "Producto: ${producto.nombre}", Toast.LENGTH_SHORT).show()
                }
                recyclerViewProducts.adapter = productAdapter

                // Mostrar mensaje si no hay productos
                if (productos.isEmpty()) {
                    Log.d(TAG, "No hay productos en esta categoría")
                    Toast.makeText(this, "No hay productos en esta categoría", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { exception ->
                // Manejar errores
                Log.e(TAG, "Error al cargar productos: ${exception.message}", exception)
                Toast.makeText(this, "Error al cargar productos: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun loadProductImage(producto: Producto) {
        if (producto.imagenUrl.isNotEmpty()) {
            val storageReference = FirebaseStorage.getInstance().getReferenceFromUrl(producto.imagenUrl)

            storageReference.downloadUrl.addOnSuccessListener { uri ->
                // Update the producto's image URL with the download URL
                producto.imagenUrl = uri.toString()
                // Notify the adapter that the data has changed
                productAdapter.notifyDataSetChanged()
            }.addOnFailureListener { exception ->
                Log.e(TAG, "Error al cargar imagen: ${exception.message}")
            }
        }
    }
}