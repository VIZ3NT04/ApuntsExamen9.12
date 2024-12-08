package com.example.examengpt.Pojo

import java.io.Serializable

class Pais (private var nombre: String,private var ciudades: List<Ciudad>):Serializable {
    fun getNombre(): String {
        return nombre
    }

    fun getCiudades(): List<Ciudad> {
        return ciudades
    }

    fun setCiudades(nuevoCiudades: List<Ciudad>) {
        ciudades = nuevoCiudades
    }

    fun setNombre(nuevoNombre: String) {
        nombre = nuevoNombre
    }


}