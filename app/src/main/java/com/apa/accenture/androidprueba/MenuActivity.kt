package com.apa.accenture.androidprueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.apa.accenture.androidprueba.firstapp.FirstAppActivity
import com.apa.accenture.androidprueba.imccalculator.ImcCalculatorActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        val btnImcApp = findViewById<Button>(R.id.btnIMCApp)
        btnSaludApp.setOnClickListener{navigateToSaludApp()}
        btnImcApp.setOnClickListener{navigateToIMCApp()}
    }

    private fun navigateToSaludApp(){
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToIMCApp(){
 val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }
}