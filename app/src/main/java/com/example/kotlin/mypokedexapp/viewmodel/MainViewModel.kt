package com.example.kotlin.mypokedexapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.mypokedexapp.model.PokedexObject
import com.example.kotlin.mypokedexapp.model.PokemonRepository
import com.example.kotlin.mypokedexapp.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val pokedexObjectLiveData = MutableLiveData<PokedexObject>()
    fun getPokemonList(){
        viewModelScope.launch(Dispatchers.IO) {
            val pokemonRepository = PokemonRepository()
            val result: PokedexObject? = pokemonRepository.getPokemonList(Constants.MAX_POKEMON_NUMBER)
            Log.d("Salida", result?.count.toString())
            CoroutineScope(Dispatchers.Main).launch {
                pokedexObjectLiveData.postValue(result)
            }
        }
    }
}