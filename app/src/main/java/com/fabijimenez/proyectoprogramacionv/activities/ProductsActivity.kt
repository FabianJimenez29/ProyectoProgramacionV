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
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProductsActivity : AppCompatActivity() {
    private lateinit var recyclerViewProducts: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private val productos = mutableListOf<Producto>()
    private val TAG = "ProductsActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        // Recuperar la categoría pasada desde ShopActivity
        val category = intent.getParcelableExtra<Category>("category")

        category?.let {
            supportActionBar?.title = it.name

            // Configurar RecyclerView
            recyclerViewProducts = findViewById(R.id.recyclerViewProducts)
            recyclerViewProducts.layoutManager = GridLayoutManager(this, 2)

            // Obtener los productos de la categoría desde Realtime Database
            getProductsForCategory(category)
        }
    }

    private fun getProductsForCategory(category: Category?) {
        if (category == null) {
            Toast.makeText(this, "Categoría no seleccionada", Toast.LENGTH_SHORT).show()
            return
        }

        val database = FirebaseDatabase.getInstance()
        val productsRef = database.getReference("productos")

        productsRef.orderByChild("categoria/name").equalTo(category.name)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    Log.d(TAG, "Productos encontrados: ${snapshot.childrenCount}")
                    productos.clear()

                    for (productSnapshot in snapshot.children) {
                        val producto = productSnapshot.getValue(Producto::class.java)
                        producto?.let {
                            Log.d(TAG, "Cargando producto: ${it.nombre}")
                            productos.add(it)
                        }
                    }

                    // Configurar el adaptador
                    productAdapter = ProductAdapter(productos) { producto ->
                        // Manejar clic en producto (opcional)
                        Toast.makeText(this@ProductsActivity, "Producto: ${producto.nombre}", Toast.LENGTH_SHORT).show()
                    }
                    recyclerViewProducts.adapter = productAdapter

                    // Mostrar mensaje si no hay productos
                    if (productos.isEmpty()) {
                        Log.d(TAG, "No hay productos en esta categoría")
                        Toast.makeText(this@ProductsActivity, "No hay productos en esta categoría", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Manejar errores
                    Log.e(TAG, "Error al cargar productos: ${error.message}", error.toException())
                    Toast.makeText(this@ProductsActivity, "Error al cargar productos: ${error.message}", Toast.LENGTH_SHORT).show()
                }
            })
    }
}