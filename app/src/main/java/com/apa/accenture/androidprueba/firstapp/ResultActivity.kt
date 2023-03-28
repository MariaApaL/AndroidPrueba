package com.apa.accenture.androidprueba.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.TextView
import com.apa.accenture.androidprueba.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        var tvResult = findViewById<TextView>(R.id.tvResult)
        var name: String = intent.extras?.getString("EXTRA_NAME").orEmpty()
        tvResult.text= "Hola $name"
    }
}