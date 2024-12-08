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

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.btnNext.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

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
             imageView.setImageResource(R.drawable.icono)
         }
         return !click
     }
}