package com.periferia.metas_amway.network.models

import com.google.gson.annotations.SerializedName


data class CodeAmway(
    val message: String,
    val codigoOperacion: Int,
    val respuesta: List<Any>
)