package com.example.examengpt.Activities

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.examengpt.Adapters.OnClickListener
import com.example.examengpt.Fragments.FragmentRecycle
import com.example.examengpt.Fragments.FragmentSpinner
import com.example.examengpt.R
import com.example.examengpt.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isTablet: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Habilitar edge-to-edge y configurar View Binding
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Determinar si estamos en tablet o móvil0
        isTablet = binding.contenedorFragmentSpinner != null

        if (isTablet) {
            // Cargar ambos fragmentos en modo tablet
            loadBothFragments(FragmentRecycle(), FragmentSpinner())
            binding.btnSpiner.visibility = View.GONE
            binding.btnRecycle.visibility = View.GONE

        } else {
            // Configurar botones para cargar fragmentos en modo móvil
            binding.btnRecycle.setOnClickListener {
                loadFragment(FragmentRecycle())
            }
            binding.btnSpiner.setOnClickListener {
                loadFragment(FragmentSpinner())
            }
        }
    }

    private fun loadBothFragments(fragment1: Fragment, fragment2: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.contenedorFragments, fragment1)
        transaction.replace(R.id.contenedorFragmentSpinner, fragment2)
        transaction.commit()
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.contenedorFragments, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
