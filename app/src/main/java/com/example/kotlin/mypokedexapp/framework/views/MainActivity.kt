package com.example.kotlin.mypokedexapp.framework.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.mypokedexapp.framework.adapters.PokemonAdapter
import com.example.kotlin.mypokedexapp.databinding.ActivityMainBinding
import com.example.kotlin.mypokedexapp.data.network.model.PokemonBase
import com.example.kotlin.mypokedexapp.framework.viewmodel.MainViewModel

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