package com.example.kotlin.mypokedexapp.pokemon

import com.google.gson.annotations.SerializedName

data class Versions(
    @SerializedName("generation-i") val generationI: GenerationI,
    @SerializedName("generation-ii") val generationII: GenerationIi,
    @SerializedName("generation-i") val generationIii: GenerationIii,
    @SerializedName("generation-i") val generationIv: GenerationIv,
    @SerializedName("generation-i") val generationV: GenerationV,
    @SerializedName("generation-i") val generationVi: GenerationVi,
    @SerializedName("generation-i") val generationVii: GenerationVii,
    @SerializedName("generation-i") val generationViii: GenerationViii,
)