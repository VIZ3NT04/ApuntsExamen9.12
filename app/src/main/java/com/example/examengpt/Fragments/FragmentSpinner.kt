package com.example.examengpt.Fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import com.example.examengpt.R
import com.example.examengpt.databinding.FragmentSpinnerBinding

class FragmentSpinner : Fragment() {

    private lateinit var binding: FragmentSpinnerBinding
    private lateinit var webView: WebView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Initialize the binding property
        binding = FragmentSpinnerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up the spinner here
        val datos = arrayOf("Fragment de color Raphael", "Fragment de Leonardo", "Fragment de Mikelangelo","Fragment de Donatello")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, datos)
        val spinner = binding.cmbOpciones

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                webView = binding.webView

                // Configuración del WebView
                webView.webViewClient = WebViewClient()  // Para abrir enlaces dentro del WebView
                webView.settings.javaScriptEnabled = true  // Habilitar JavaScript si es necesario

                // Cargar una URL (Ejemplo: Wikipedia)

                when (position) {
                    0 -> {
                        binding.frameLayout.setBackgroundColor(Color.RED)
                        webView.loadUrl("https://es.wikipedia.org/wiki/Raphael_(Tortugas_ninja)")
                    }

                    1 -> {
                        binding.frameLayout.setBackgroundColor(Color.BLUE)
                        webView.loadUrl("https://es.wikipedia.org/wiki/Leonardo_(Tortugas_ninja)")
                    }

                    2 -> {
                        val orangeColor = ContextCompat.getColor(requireContext(), R.color.orange)
                        binding.frameLayout.setBackgroundColor(orangeColor)
                        webView.loadUrl("https://es.wikipedia.org/wiki/Michelangelo_(Tortugas_ninja)")

                    }

                    3 -> {
                        binding.frameLayout.setBackgroundColor(Color.MAGENTA)
                        webView.loadUrl("https://es.wikipedia.org/wiki/Donatello_(Tortugas_ninja)")
                    }
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
}
