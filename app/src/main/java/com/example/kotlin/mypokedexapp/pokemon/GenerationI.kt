package com.example.kotlin.mypokedexapp.pokemon

import com.google.gson.annotations.SerializedName

data class GenerationI(
    @SerializedName("red-blue") val redBlue: RedBlue,
    @SerializedName("yellow") val yellow: Yellow,
)