package com.apa.accenture.androidprueba.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apa.accenture.androidprueba.R

//ontaskselected es una funcion lambda
class TasksAdapter(private val tasks: List<Task>, private val onTaskSelected: (Int) -> Unit) :
    RecyclerView.Adapter<TasksViewFolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewFolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_todo_task, parent, false)
        return TasksViewFolder(view)
    }

    override fun onBindViewHolder(holder: TasksViewFolder, position: Int) {
        holder.render(tasks[position])
        //la celda entera
        holder.itemView.setOnClickListener { onTaskSelected(position) }
        onTaskSelected(position)
    }

    override fun getItemCount() = tasks.size

}