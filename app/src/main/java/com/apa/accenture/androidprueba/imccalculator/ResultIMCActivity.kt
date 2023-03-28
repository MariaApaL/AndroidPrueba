package com.apa.accenture.androidprueba.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.apa.accenture.androidprueba.R
import com.apa.accenture.androidprueba.imccalculator.ImcCalculatorActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {
    private lateinit var tvResult:TextView
    private lateinit var tvIMC:TextView
    private lateinit var tvDescription:TextView
    private lateinit var btnRecalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        val result = intent.extras?.getDouble(IMC_KEY) ?: -1.0;
        initComponents()
        initUI(result)
        initListeners()
    }

    private fun initListeners() {
        btnRecalculate.setOnClickListener { onBackPressed() }
    }

    private fun initUI(result:Double) {
        tvIMC.text=result.toString()
        when(result){
            in 0.00.. 18.50 ->{

                tvResult.text = getString(R.string.title_bajo_peso)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.peso_bajo))
                tvDescription.text = getString(R.string.description_bajo_peso)

            }
            in 18.51.. 24.99 ->{

                tvResult.text = getString(R.string.title_normal_peso)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.peso_normal))
                tvDescription.text = getString(R.string.description_normal_peso)

            }
            in 25.00..29.99 ->{

                tvResult.text = getString(R.string.title_sobrepeso_peso)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.peso_sobrepeso))
                tvDescription.text = getString(R.string.description_sobrepeso_peso)

            }
            in 30.00..99.00 ->{

                tvResult.text = getString(R.string.title_obesidad_peso)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.peso_obesidad))
                tvDescription.text = getString(R.string.description_obesidad_peso)

            }
            else->{
                tvIMC.text = getString(R.string.error)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.peso_obesidad))
                tvResult.text = getString(R.string.error)
                tvDescription.text =getString(R.string.error)

            }
        }
    }

    private fun initComponents() {
        tvIMC = findViewById(R.id.tvIMC)
        tvResult = findViewById(R.id.tvResult)
        tvDescription = findViewById(R.id.tvDescription)
        btnRecalculate = findViewById(R.id.btnReCalculate)
    }
}