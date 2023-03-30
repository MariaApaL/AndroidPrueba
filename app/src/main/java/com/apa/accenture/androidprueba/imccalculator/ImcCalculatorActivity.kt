package com.apa.accenture.androidprueba.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.apa.accenture.androidprueba.R
import com.apa.accenture.androidprueba.firstapp.ResultActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true;
    private var isFemaleSelected: Boolean = false;
    private var currentWeight: Int = 60;
    private var currentAge:Int = 20;
    private var currentHeight: Int =120;

    //Lateinit no se inicia ya, se inicia cuando nosotros le digamos
    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton
    private lateinit var tvWeight: TextView
    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var btnCalculate: Button

    companion object{
        const val IMC_KEY ="IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
        initListeners()
        initUi()
    }


    //Inicializa los componentes
    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale);
        viewFemale = findViewById(R.id.viewFemale);
        tvHeight = findViewById(R.id.tvHeight);
        rsHeight = findViewById(R.id.rsHeight);
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight);
        btnPlusWeight = findViewById(R.id.btnPlusWeight);
        tvWeight = findViewById(R.id.tvWeight);
        btnSubtractAge = findViewById(R.id.btnSubtractAge);
        btnPlusAge = findViewById(R.id.btnPlusAge);
        tvAge = findViewById(R.id.tvAge);
        btnCalculate = findViewById(R.id.btnCalculate);
    }

    //crea el evento de click
    private fun initListeners() {
        viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }

        rsHeight.addOnChangeListener { _, value, _ ->

            //decimos que el valor sera 1 valor y 2 decimales
            val df = DecimalFormat("#.##")
            currentHeight  = df.format(value).toInt();
            tvHeight.text = "$currentHeight cm"
        }

        btnPlusWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }

        btnSubtractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }

        btnPlusAge.setOnClickListener {
            currentAge += 1
            setAge()
        }

        btnSubtractAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }

        btnCalculate.setOnClickListener{
           val result=  calculateIMC()
            navigateToResultActivity(result)
        }

    }

    private fun navigateToResultActivity(result:Double) {
        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY,result)
        startActivity(intent)

    }

    private fun calculateIMC():Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeight.toDouble()/100 *currentHeight.toDouble()/100)
        return df.format(imc).toDouble();


    }

    private fun setAge() {
        tvAge.text = currentAge.toString();
    }

    private fun setWeight() {
       tvWeight.text = currentWeight.toString()
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected;
        isFemaleSelected = !isFemaleSelected;
    }

    private fun setGenderColor() {

        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected));
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected));

    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }
        //Obtenemos el color
        return ContextCompat.getColor(this, colorReference);
    }

    private fun initUi() {
        setGenderColor()
        setWeight()
        setAge()
    }
}