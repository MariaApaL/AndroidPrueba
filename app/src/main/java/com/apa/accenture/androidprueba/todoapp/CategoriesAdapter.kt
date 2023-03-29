package com.apa.accenture.androidprueba.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apa.accenture.androidprueba.R

//Pinta las vistas y las adapta
class CategoriesAdapter (private val categories: List<TaskCategory>, private val onItemSelected:(Int)->Unit):
    RecyclerView.Adapter<CategoriesViewFolder>() {


    //crea una vista visual ( para ello creamos un nuevo layout "item_..")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewFolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task_category, parent, false)
        return CategoriesViewFolder(view)
    }

    //Tamaño del listado
    override fun getItemCount() = categories.size

    override fun onBindViewHolder(holder: CategoriesViewFolder, position: Int) {
        holder.render(categories[position], onItemSelected)
    }

}