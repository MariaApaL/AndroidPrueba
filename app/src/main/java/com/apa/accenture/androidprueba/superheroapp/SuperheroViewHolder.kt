package com.apa.accenture.androidprueba.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.apa.accenture.androidprueba.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperheroViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)
    fun bind(superheroItemResponse: SuperheroItemResponse, onItemSelected: (String) -> Unit){
        binding.tvSuperheroName.text=superheroItemResponse.name

        Picasso.get().load(superheroItemResponse.superheroImage.url).into(binding.ivSuperhero)
        //root es el item. Por lo tanto, donde sea que se pulse detro del item recogera el id
        binding.root.setOnClickListener { onItemSelected(superheroItemResponse.superheroId) }

    }
}