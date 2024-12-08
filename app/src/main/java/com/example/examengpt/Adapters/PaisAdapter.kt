package com.example.examengpt.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examengpt.Pojo.Pais
import com.example.examengpt.R
import com.example.examengpt.databinding.ItemPaisBinding

class PaisAdapter (private val paises: List<Pais>,private val listener: OnClickListener): RecyclerView.Adapter<PaisAdapter.ViewHolder>(){
    private lateinit var context: Context
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        // Inicializamos el binding (item)
        val binding = ItemPaisBinding.bind(view)
        // Llamamos a onClickListener
        fun setListener(pais: Pais) {
            binding.root.setOnClickListener { listener.onClick(pais) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaisAdapter.ViewHolder {
        // Inflamos la vista del Intem del Recycler
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_pais, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PaisAdapter.ViewHolder, position: Int) {
        // Insertamos al item la informacio de los Objetos (Pais)
        val pais = paises.get(position)
        holder.setListener(pais)
        with(holder){
            binding.lblNombre.text = pais.getNombre()
        }
    }

    // Se hace pero no se para que es
    override fun getItemCount(): Int = paises.size


}