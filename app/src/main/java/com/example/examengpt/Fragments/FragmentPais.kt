package com.example.examengpt.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examengpt.Adapters.CiudadAdapter  // Adaptador para mostrar la lista de ciudades
import com.example.examengpt.Adapters.OnCiudadSelected // Interfaz para manejar la selección de una ciudad
import com.example.examengpt.Pojo.Ciudad // Clase que representa una ciudad
import com.example.examengpt.Pojo.Pais // Clase que representa un país
import com.example.examengpt.R
import com.example.examengpt.databinding.FragmentPaisBinding // Binding para acceder a las vistas del XML asociado al fragmento

// Clase FragmentPais: muestra los detalles de un país y su lista de ciudades
class FragmentPais : Fragment(), OnCiudadSelected {

    // Declaración de variables:
    private lateinit var binding: FragmentPaisBinding // Para acceder al diseño del fragmento (fragment_pais.xml)
    private lateinit var pais: Pais // Objeto que representa el país seleccionado
    private lateinit var ciudadAdapter: CiudadAdapter // Adaptador para manejar la lista de ciudades
    private lateinit var linearLayoutManager: LinearLayoutManager // LayoutManager para el RecyclerView

    // Este método crea la vista asociada al fragmento y la inicializa
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Vinculamos el diseño del fragmento usando View Binding
        binding = FragmentPaisBinding.inflate(inflater, container, false)

        // Recuperamos el objeto 'pais' enviado como argumento al fragmento
        pais = arguments?.getSerializable("pais") as Pais

        // Devolvemos la raíz del diseño vinculado
        return binding.root
    }

    // Este método se ejecuta después de que la vista se ha creado y se pueden inicializar componentes
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Verificamos si el país no es nulo (es decir, se pasó correctamente como argumento)
        if (pais != null) {
            // Inicializamos el adaptador con la lista de ciudades del país y la interfaz OnCiudadSelected
            ciudadAdapter = CiudadAdapter(pais.getCiudades(), this)

            // Configuramos un LayoutManager para manejar la disposición de los elementos en el RecyclerView
            linearLayoutManager = LinearLayoutManager(requireContext())

            // Configuramos el RecyclerView de la vista con el LayoutManager y el adaptador
            binding.RecyclerViewCiudades.apply {
                layoutManager = linearLayoutManager
                adapter = ciudadAdapter
            }
        }
    }

    // Implementación de la función de la interfaz OnCiudadSelected
    // Este método se llama cuando el usuario selecciona una ciudad en la lista
    override fun onCiudadSelected(ciudad: Ciudad) {
        // Mostramos un mensaje emergente (Toast) con el nombre de la ciudad y su número de habitantes
        Toast.makeText(
            requireContext(),
            "Has seleccionado ${ciudad.nombre} con ${ciudad.habitantes} habitantes!",
            Toast.LENGTH_SHORT
        ).show()
    }
}
