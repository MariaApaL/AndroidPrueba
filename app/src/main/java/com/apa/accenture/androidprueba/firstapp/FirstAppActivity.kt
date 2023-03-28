package com.apa.accenture.androidprueba.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.apa.accenture.androidprueba.R

class FirstAppActivity : AppCompatActivity() {

    //Metodo principal, se ejecuta lo primero, al arrancar la pantalla
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)
        //Enganchamos el id del elemento, con el tipo (AppCompatButton)
        val btnStart = findViewById<AppCompatButton>(R.id.btnStart)
        val etName = findViewById<AppCompatEditText>(R.id.etName)


        btnStart.setOnClickListener{
            val name = etName.text.toString()
            if(name.isNotEmpty()) {
                //Intent es para conectar las activities
                val intent = Intent(this, ResultActivity::class.java )
                intent.putExtra("EXTRA_NAME",name);
                startActivity(intent)
            }
        }

    }
}