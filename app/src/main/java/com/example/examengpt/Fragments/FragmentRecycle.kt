package com.example.examengpt.Fragments

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examengpt.Adapters.OnClickListener
import com.example.examengpt.Adapters.PaisAdapter
import com.example.examengpt.Pojo.Pais
import com.example.examengpt.Pojo.PaisDatos
import com.example.examengpt.R
import com.example.examengpt.databinding.FragmentRecycleBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.example.examengpt.Fragments.FragmentPais
import com.example.examengpt.databinding.ActivityMainBinding

class FragmentRecycle : Fragment(), OnClickListener {

    private lateinit var paisAdapter: PaisAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var binding: FragmentRecycleBinding // Directamente lateinit sin nullables
    private lateinit var mainBinding: ActivityMainBinding
    private var isTablet: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inicializamos el binding directamente
        binding = FragmentRecycleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configuramos el RecyclerView
        paisAdapter = PaisAdapter(PaisDatos.PAIS, this)
        linearLayoutManager = LinearLayoutManager(requireContext())
        binding.RecyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = paisAdapter
        }
    }

    override fun onClick(pais: Pais) {
        // Hacemos el dialogo personalizado en la funcion del OnClickListener (inteface)
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Quieres entrar a ${pais.getNombre()}?")
            .setPositiveButton("Aceptar", DialogInterface.OnClickListener { dialog, i ->
                //Fer el accept y recoger el objeto pais ( La clase pais tiene que estar en Serializable)
                val fragmentPais = FragmentPais()
                val bundle = Bundle()
                bundle.putSerializable("pais",pais)
                fragmentPais.arguments = bundle
                loadFragment(fragmentPais)
            })
            .setNegativeButton("Cancelar", null)
            .show()
    }
    private fun loadFragment(fragment: Fragment) {
        // Revisamos si estamos en tablet o el movil
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        isTablet = mainBinding.contenedorFragmentSpinner != null

        if (isTablet) {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.contenedorFragmentSpinner, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        } else {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.contenedorFragments, fragment)
            transaction.addToBackStack(null)
            transaction.commit()

        }    }
}
