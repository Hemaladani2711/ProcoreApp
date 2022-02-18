package com.example.procoreapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.procoreapp.modal.Datum
import com.example.procoreapp.modal.Pokemon
import com.squareup.picasso.Picasso

class PokemonDataAdapter(): RecyclerView.Adapter<PokemonDataAdapter.PokemonViewHolder>() {
    var data:List<Datum>? = null
    inner class PokemonViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) {
        val items:ImageView
        init {
            items=itemview.findViewById(R.id.items)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_items,parent,false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val data = data?.get(position) ?: return
        Picasso.get().load(data.images?.small).into(holder.items)
    }

    override fun getItemCount() = data?.size?:0
    public fun updateData(items:List<Datum>){
        //data = items
        notifyDataSetChanged()
    }
    public fun searchResults(search:String){
        val searchResults = mutableListOf<Datum>()
        data?.let{
            for(i in it){
                if(i.name?.contains(search)==true){
                    searchResults.add(i)
                }
            }
            updateData(searchResults)
        }

    }
}