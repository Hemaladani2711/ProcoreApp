package com.example.procoreapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var mainViewModel: MainViewModel
    lateinit var edtSearch:EditText
    var pokemonDataAdapter:PokemonDataAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview)
        edtSearch=findViewById(R.id.edt_search)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.fetchData().observe(this,{pokemons->
                Log.d("",""+pokemons.data)
                pokemonDataAdapter = PokemonDataAdapter()
                pokemonDataAdapter?.updateData(pokemons.data?: emptyList())
                recyclerView.adapter = pokemonDataAdapter
                recyclerView.layoutManager=GridLayoutManager(this,3)
            }
        )
        edtSearch.doOnTextChanged { text, start, before, count ->
            pokemonDataAdapter?.searchResults(text.toString())

        }


    }
}