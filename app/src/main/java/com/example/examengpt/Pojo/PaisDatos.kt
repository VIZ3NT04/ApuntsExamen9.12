package com.example.examengpt.Pojo

import com.example.examengpt.R

class PaisDatos {
    companion object {
        val PAIS = arrayListOf(
            Pais("España", listOf(
                Ciudad("Madrid",1000000f, R.drawable.spain),
                Ciudad("Barcelona",800000f, R.drawable.spain),
                Ciudad("Valencia",500000f, R.drawable.spain)
                )),
                Pais("Portugal", listOf(
                    Ciudad("Oporto",900000f, R.drawable.portugal),
                    Ciudad("Lisboa",1200000f, R.drawable.portugal),
                    Ciudad("Guimaraes",250000f, R.drawable.portugal)
                )),
                Pais("Polonia", listOf(
                    Ciudad("Pozdan", 500000f, R.drawable.poland),
                    Ciudad("Worclaw",800000f, R.drawable.poland),
                    Ciudad("Varsovia",3000000f, R.drawable.poland)
                ))
        )
    }
}