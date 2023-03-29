package com.apa.accenture.androidprueba.todoapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.apa.accenture.androidprueba.R
import com.apa.accenture.androidprueba.mutableList
import com.apa.accenture.androidprueba.todoapp.TaskCategory.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TodoActivity : AppCompatActivity() {

    private val categories = listOf(
        //Lo que reciba aqui es lo que va a pintar
        Business,
        Personal,
        Other
    )

    private val tasks = mutableListOf(
        Task("pruebaOtro", Other),
        Task("pruebaPersonal", Personal),
        Task("pruebaBusiness", Business)

    )

    //recycle view necesita dos cosas, el adapter y el view folder
    private lateinit var rvCategories: RecyclerView
    private lateinit var rvTasks: RecyclerView
    private lateinit var tasksAdapter: TasksAdapter
    private lateinit var fabAddTask: FloatingActionButton
    private lateinit var categoriesAdapter: CategoriesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponent()
        initUI()
        initListeners()
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        //enganchamos el xml
        dialog.setContentView(R.layout.dialog_task)
        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener {
            val currentTask = etTask.text.toString()
            if (currentTask.isNotEmpty()) {
                val selectedId = rgCategories.checkedRadioButtonId
                //accedemos a un radio button del radio group
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: TaskCategory =
                    when (selectedRadioButton.text) {
                        getString(R.string.todo_dialog_category_business) -> Business
                        getString(R.string.todo_dialog_category_personal) -> Personal
                        else -> Other
                    }
                tasks.add(Task(etTask.text.toString(), currentCategory))
                updateTasks()
                dialog.hide()
            }
        }
        dialog.show()
    }


    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories){}
        //Se encarga de poner si es vertical  u horizontal:
        rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        //
        tasksAdapter = TasksAdapter(tasks){position -> onItemSelected(position)}
        //Se pone solo this porque el que viene por defecto es el vertical
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = tasksAdapter

    }

    private fun
    private fun onItemSelected(position:Int){
        tasks[position].isSelected = !tasks[position].isSelected
        updateTasks()

    }

    private fun updateTasks(){

        tasksAdapter.notifyDataSetChanged()
    }
}