package com.fabijimenez.proyectoprogramacionv.adapters

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.fabijimenez.proyectoprogramacionv.R
import com.fabijimenez.proyectoprogramacionv.classes.Category

class ShopActivity : AppCompatActivity() {
    private var categoryRecyclerView: RecyclerView? = null
    private var categoryAdapter: CategoryAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        categoryRecyclerView = findViewById(R.id.categoryRecyclerView)

        // Usamos un StaggeredGridLayoutManager para crear una cuadrícula fluida
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL) // 2 columnas
        categoryRecyclerView?.layoutManager = layoutManager

        // Crear el adapter y asignarlo al RecyclerView
        // Add an onCategoryClicked listener
        categoryAdapter = CategoryAdapter(categories) { category ->
            // Handle category click here
            // For example, you might want to open a new activity or fragment
            // based on the selected category
            // For now, we'll just print the category name
            println("Clicked category: ${category.name}")
        }
        categoryRecyclerView?.adapter = categoryAdapter
    }

    private val categories: List<Category>
        // Función para obtener los datos de las categorías
        get() {
            val categories: MutableList<Category> = ArrayList()
            categories.add(Category("Baterias", R.drawable.image2)) // image2.webp
            categories.add(Category("Frenos", R.drawable.image3))   // image3.webp
            categories.add(Category("Llantas", R.drawable.image4))  // image4.webp
            categories.add(Category("Lubricantes", R.drawable.image5)) // image5.webp
            categories.add(Category("Detalle Automotriz", R.drawable.image6)) // image6.webp
            categories.add(Category("Filtros de Aceite", R.drawable.image7)) // image7.webp
            categories.add(Category("Amortiguadores", R.drawable.image8)) // image8.webp
            categories.add(Category("Refrigerante", R.drawable.image9)) // image9.webp
            categories.add(Category("Cepillos", R.drawable.image10)) // image10.webp
            return categories
        }
}