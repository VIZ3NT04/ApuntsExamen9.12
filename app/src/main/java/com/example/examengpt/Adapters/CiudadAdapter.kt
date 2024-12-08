package com.example.examengpt.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examengpt.Pojo.Ciudad
import com.example.examengpt.Pojo.Pais
import com.example.examengpt.R
import com.example.examengpt.databinding.ItemCiudadBinding
import com.example.examengpt.databinding.ItemPaisBinding

class CiudadAdapter (private val ciudades: List<Ciudad>, private val listener: OnCiudadSelected): RecyclerView.Adapter<CiudadAdapter.ViewHolder>(){
    private lateinit var context: Context
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemCiudadBinding.bind(view)
        fun setListener(ciudad: Ciudad) {
            binding.root.setOnClickListener { listener.onCiudadSelected(ciudad) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CiudadAdapter.ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_ciudad, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CiudadAdapter.ViewHolder, position: Int) {
        val ciudad = ciudades.get(position)
        holder.setListener(ciudad)
        with(holder){
            binding.lblNombre.text = ciudad.nombre
            binding.lblHabitantes.text = ciudad.habitantes.toString()
            binding.img.setImageResource(ciudad.imagen)
        }
    }

    override fun getItemCount(): Int = ciudades.size

}