package com.example.procoreapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.procoreapp.modal.Pokemon
import com.squareup.picasso.Picasso

class PokemonDataAdapter(val items:Pokemon): RecyclerView.Adapter<PokemonDataAdapter.PokemonViewHolder>() {
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
        val data = items.data?.get(position) ?: return
        Picasso.get().load(data.images?.small).into(holder.items)
    }

    override fun getItemCount() = items.data?.size?:0
}