package com.example.kotlin.mypokedexapp.views

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.mypokedexapp.utils.Constants
import com.example.kotlin.mypokedexapp.adapters.PokemonAdapter
import com.example.kotlin.mypokedexapp.databinding.ActivityMainBinding
import com.example.kotlin.mypokedexapp.model.PokedexObject
import com.example.kotlin.mypokedexapp.model.PokemonBase
import com.example.kotlin.mypokedexapp.model.PokemonRepository
import com.example.kotlin.mypokedexapp.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter : PokemonAdapter = PokemonAdapter()
    private lateinit var data:ArrayList<PokemonBase>
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        initializeObservers()
        viewModel.getPokemonList()
    }

    private fun initializeObservers() {
        viewModel.pokedexObjectLiveData.observe(this){ poxedexObject ->
            setUpRecyclerView(poxedexObject.results)
        }
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setUpRecyclerView(dataForList:ArrayList<PokemonBase>){
        binding.RVPokemon.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)
        binding.RVPokemon.layoutManager = linearLayoutManager
        adapter.PokemonAdapter(dataForList,this)
        binding.RVPokemon.adapter = adapter
    }

}