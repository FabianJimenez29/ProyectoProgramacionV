package com.fabijimenez.proyectoprogramacionv.activities


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.fabijimenez.proyectoprogramacionv.adapters.CategoryAdapter
import com.fabijimenez.proyectoprogramacionv.R
import com.fabijimenez.proyectoprogramacionv.classes.Category
import com.google.android.material.bottomnavigation.BottomNavigationView

class ShopActivity : AppCompatActivity() {
    private var categoryRecyclerView: RecyclerView? = null
    private var categoryAdapter: CategoryAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)


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

                    if (javaClass != ShopActivity::class.java) {
                        startActivity(Intent(this, ShopActivity::class.java))
                    }
                    true
                }
                R.id.nav_profile -> {

                    if (javaClass != ProfileActivity::class.java) {
                        startActivity(Intent(this, ProfileActivity::class.java))
                    }
                    true
                }
                R.id.nav_branches -> {

                    if (javaClass != BranchesActivity::class.java) {
                        startActivity(Intent(this, BranchesActivity::class.java))
                    }
                    true
                }
                R.id.nav_contact -> {

                    if (javaClass != ContactActivity::class.java) {
                        startActivity(Intent(this, ContactActivity::class.java))
                    }
                    true
                }
                else -> false
            }
        }

        // Establecer el ítem seleccionado por defecto
        bottomNavigationView.selectedItemId = R.id.nav_store

        categoryRecyclerView = findViewById(R.id.categoryRecyclerView)

        // Usamos un GridLayoutManager para organizar las categorías en 3 columnas
        val layoutManager = GridLayoutManager(this, 3) // 3 columnas para las categorías
        categoryRecyclerView?.layoutManager = layoutManager

        // Crear el adapter y asignarlo al RecyclerView
        categoryAdapter = CategoryAdapter(categories)
        categoryRecyclerView?.adapter = categoryAdapter
    }

    private val categories: List<Category>
        get() {
            val categories: MutableList<Category> = ArrayList()
            categories.add(Category("Baterías", R.drawable.image2))
            categories.add(Category("Frenos", R.drawable.image3))
            categories.add(Category("Llantas", R.drawable.image4))
            categories.add(Category("Lubricantes", R.drawable.image5))
            categories.add(Category("Detalle Automotriz", R.drawable.image6))
            categories.add(Category("Filtros de Aceite", R.drawable.image7))
            categories.add(Category("Suspenciones", R.drawable.image8))
            categories.add(Category("Refrigerantes", R.drawable.image9))
            categories.add(Category("Escobillas", R.drawable.image10))
            return categories
        }
}

