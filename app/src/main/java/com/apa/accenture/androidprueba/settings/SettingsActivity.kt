package com.apa.accenture.androidprueba.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apa.accenture.androidprueba.R
import com.apa.accenture.androidprueba.databinding.ActivitySettingBinding


class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}