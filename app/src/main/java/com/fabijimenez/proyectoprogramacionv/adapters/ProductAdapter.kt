package com.fabijimenez.proyectoprogramacionv.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.fabijimenez.proyectoprogramacionv.R
import com.fabijimenez.proyectoprogramacionv.classes.Producto
import java.text.NumberFormat
import java.util.Locale

class ProductAdapter(
    private val productos: MutableList<Producto>,
    val onClick: (Producto) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageViewProduct: ImageView = itemView.findViewById(R.id.imageViewProduct)
        private val textViewProductName: TextView = itemView.findViewById(R.id.textViewProductName)
        private val textViewProductDescription: TextView = itemView.findViewById(R.id.textViewProductDescription)
        private val textViewProductPrice: TextView = itemView.findViewById(R.id.textViewProductPrice)

        fun bind(producto: Producto, onClick: (Producto) -> Unit) {
            // Setear los detalles del producto
            textViewProductName.text = producto.nombre
            textViewProductDescription.text = producto.descripcion

            // Formatear el precio con la moneda
            val currencyFormatter = NumberFormat.getCurrencyInstance(Locale("es", "CO"))
            textViewProductPrice.text = currencyFormatter.format(producto.precio)

            // Cargar la imagen usando Glide
            Glide.with(itemView.context)
                .load(producto.imagenUrl)
                .placeholder(R.drawable.placeholder_image) // Imagen de carga
                .error(R.drawable.error_image) // Imagen de error
                .transition(DrawableTransitionOptions.withCrossFade()) // Transición suave
                .into(imageViewProduct)

            itemView.setOnClickListener { onClick(producto) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item_layout, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productos[position], onClick)
    }

    override fun getItemCount() = productos.size

    // Método para actualizar la lista de productos
    fun updateProductos(nuevosProductos: List<Producto>) {
        productos.clear()
        productos.addAll(nuevosProductos)
        notifyDataSetChanged()
    }
}