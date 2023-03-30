package com.apa.accenture.androidprueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.apa.accenture.androidprueba.firstapp.FirstAppActivity
import com.apa.accenture.androidprueba.imccalculator.ImcCalculatorActivity
import com.apa.accenture.androidprueba.settings.SettingsActivity
import com.apa.accenture.androidprueba.superheroapp.SuperHeroListActivity
import com.apa.accenture.androidprueba.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        val btnImcApp = findViewById<Button>(R.id.btnIMCApp)
        val btnTODO = findViewById<Button>(R.id.btnTODO)
        val btnSuperhero = findViewById<Button>(R.id.btnSuperhero)
        val btnSettings = findViewById<Button>(R.id.btnSettings)
        btnSaludApp.setOnClickListener{navigateToSaludApp()}
        btnImcApp.setOnClickListener{navigateToIMCApp()}
        btnTODO.setOnClickListener{navigateToTodoApp()}
        btnSuperhero.setOnClickListener{navigateToSuperheroApp()}
        btnSettings.setOnClickListener{navigateToSettings()}
    }

    private fun navigateToSaludApp(){
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToIMCApp(){
         val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToTodoApp(){
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSuperheroApp(){
        val intent = Intent(this, SuperHeroListActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSettings(){
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }
}