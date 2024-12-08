package com.example.examengpt.Activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.airbnb.lottie.LottieAnimationView
import com.example.examengpt.R
import com.example.examengpt.databinding.ActivityMainBinding
import com.example.examengpt.databinding.ActivityWelcomeBinding
import com.example.examengpt.databinding.DialogoPersonalizadoBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding
    private lateinit var dialogoBinding: DialogoPersonalizadoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Inicializar el binding
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Para cambiar la vista a traves del boton
        binding.btnNext.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Para poner una animacion
        var imagen=findViewById<LottieAnimationView>(R.id.imagenEjemplo)
        var click=false

        imagen.setOnClickListener{
            click=animacion(imagen,R.raw.error404,click)
        }
    }

     fun animacion(imageView: LottieAnimationView, animacion:Int,click:Boolean):Boolean {
         if (!click) {
             imageView.setAnimation(animacion)
             imageView.playAnimation()
         } else {
             //imageView.setImageResource(R.drawable.icono)
             dialogoBinding = DialogoPersonalizadoBinding.inflate(layoutInflater)

             // Configurar el texto directamente en el binding
             dialogoBinding.primerTexto.text = "Hecho por VIZ3NT04"
             dialogoBinding.segundoTexto.text = "https://github.com/VIZ3NT04/ApuntsExamen9.12.git"

             // Crear el diálogo con la vista del binding
             val dialog = MaterialAlertDialogBuilder(this)
                 .setTitle("Título del Diálogo")
                 .setView(dialogoBinding.root) // Usar la raíz del binding
                 .show()

             // Configurar el botón de cierre en el binding
             dialogoBinding.btnDialogo.setOnClickListener {
                 dialog.dismiss() // Cerrar el diálogo correctamente
             }

         }
         return !click
     }
}