package com.example.examengpt.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examengpt.Adapters.CiudadAdapter
import com.example.examengpt.Adapters.OnCiudadSelected
import com.example.examengpt.Adapters.PaisAdapter
import com.example.examengpt.Pojo.Ciudad
import com.example.examengpt.Pojo.Pais
import com.example.examengpt.Pojo.PaisDatos
import com.example.examengpt.R
import com.example.examengpt.databinding.FragmentPaisBinding
import com.example.examengpt.databinding.FragmentRecycleBinding


class FragmentPais : Fragment(), OnCiudadSelected{
    private lateinit var binding: FragmentPaisBinding
    private var pais: Pais? = null
    private lateinit var ciudadAdapter: CiudadAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inicializamos el binding directamente

        binding = FragmentPaisBinding.inflate(inflater, container, false)
        pais = arguments?.getSerializable("pais") as? Pais
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (pais != null) {
            ciudadAdapter = CiudadAdapter(pais!!.getCiudades(), this)
            linearLayoutManager = LinearLayoutManager(requireContext())
            binding.RecyclerViewCiudades.apply {
                layoutManager = linearLayoutManager
                adapter = ciudadAdapter
        }


        }
    }
    override fun onCiudadSelected(ciudad: Ciudad) {
        Toast.makeText(requireContext(), "Has selecionado ${ciudad.nombre} con ${ciudad.habitantes} habitantes!", Toast.LENGTH_SHORT).show()
    }
}