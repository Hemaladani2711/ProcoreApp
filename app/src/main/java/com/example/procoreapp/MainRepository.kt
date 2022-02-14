package com.example.procoreapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.procoreapp.api.MyApi
import com.example.procoreapp.modal.Pokemon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository {
    fun downloadData():LiveData<Pokemon>{
        val pokeMonData = MutableLiveData<Pokemon>()
        val api = MyApi.create()
        val call = api.getPokemons()
        val callBack=call.enqueue(object : Callback<Pokemon>{
            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                response.body()?.let{items->
                    pokeMonData.value = items
                }
            }

            override fun onFailure(call: Call<Pokemon>, t: Throwable) {

            }

        }

        )
        return pokeMonData
    }
}