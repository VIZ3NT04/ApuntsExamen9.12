package com.example.examengpt.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examengpt.Pojo.Ciudad // Importamos la clase que representa una ciudad
import com.example.examengpt.R // Acceso a los recursos, como layouts e imágenes
import com.example.examengpt.databinding.ItemCiudadBinding // View Binding para el layout de cada ciudad

// Constructor del adaptador: recibe la lista de ciudades y un listener para manejar la selección de una ciudad
class CiudadAdapter(
    private val ciudades: List<Ciudad>,
    private val listener: OnCiudadSelected
) : RecyclerView.Adapter<CiudadAdapter.ViewHolder>() {

    private lateinit var context: Context // Variable para almacenar el contexto

    // Clase ViewHolder para manejar cada elemento (ciudad) en la lista
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Binding para acceder a las vistas de cada ciudad
        val binding = ItemCiudadBinding.bind(view)

        // Configura un listener para detectar clics en el elemento
        fun setListener(ciudad: Ciudad) {
            // Llama al método onCiudadSelected cuando el usuario haga clic en el elemento
            binding.root.setOnClickListener { listener.onCiudadSelected(ciudad) }
        }
    }

    // Método para crear los ViewHolders (una instancia por cada elemento visible en pantalla)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CiudadAdapter.ViewHolder {
        // Obtener el contexto desde el parent (el RecyclerView)
        context = parent.context

        // Inflar el layout del elemento (item_ciudad.xml)
        val view = LayoutInflater.from(context).inflate(R.layout.item_ciudad, parent, false)

        // Retornar un nuevo ViewHolder con la vista inflada
        return ViewHolder(view)
    }

    // Método para vincular los datos de una ciudad con el ViewHolder correspondiente
    override fun onBindViewHolder(holder: CiudadAdapter.ViewHolder, position: Int) {
        // Obtener la ciudad correspondiente a la posición actual
        val ciudad = ciudades[position]

        // Configurar el listener de clics para este ViewHolder
        holder.setListener(ciudad)

        // Usar el binding para asignar los datos de la ciudad a las vistas correspondientes
        with(holder) {
            binding.lblNombre.text = ciudad.nombre // Nombre de la ciudad
            binding.lblHabitantes.text = ciudad.habitantes.toString() // Número de habitantes
            binding.img.setImageResource(ciudad.imagen) // Imagen asociada a la ciudad
        }
    }

    // Retorna el número de elementos en la lista de ciudades
    override fun getItemCount(): Int = ciudades.size
}
