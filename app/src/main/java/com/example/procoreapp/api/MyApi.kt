package com.example.procoreapp.api

import com.example.procoreapp.modal.Pokemon
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyApi {
    companion object {
        var BASE_URL = "https://api.pokemontcg.io/v2/"
        fun create() : MyApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(MyApi::class.java)
        }
    }
    @GET("cards")
    fun getPokemons() : Call<Pokemon>
}