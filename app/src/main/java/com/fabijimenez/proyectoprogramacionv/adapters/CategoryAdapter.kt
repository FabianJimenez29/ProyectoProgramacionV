package com.fabijimenez.proyectoprogramacionv.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fabijimenez.proyectoprogramacionv.R
import com.fabijimenez.proyectoprogramacionv.classes.Category

class CategoryAdapter(
    private val categories: List<Category>,
    private val onCategoryClicked: (Category) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    // Método para crear el ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view, onCategoryClicked)
    }

    // Método para vincular los datos con el ViewHolder
    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category)
    }

    // Devuelve el número total de elementos
    override fun getItemCount(): Int = categories.size

    // ViewHolder interno
    inner class CategoryViewHolder(
        itemView: View,
        private val onCategoryClicked: (Category) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.categoryName)
        private val image: ImageView = itemView.findViewById(R.id.categoryImage)

        fun bind(category: Category) {
            name.text = category.name
            image.setImageResource(category.imageResourceId)

            // Configurar el listener de clic directamente en el método bind
            itemView.setOnClickListener {
                // Llamar al callback con la categoría actual
                onCategoryClicked(category)
            }
        }
    }
}