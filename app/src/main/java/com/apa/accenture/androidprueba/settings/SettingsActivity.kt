package com.apa.accenture.androidprueba.settings

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.apa.accenture.androidprueba.databinding.ActivitySettingBinding

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

// delegado(by) Crea una unica instancia de la bbdd y le pone el nombre.
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsActivity : AppCompatActivity() {

    companion object {
        const val VOLUME_LVL = "volume_lvl"
        const val KEY_BLUETOOTH = "key_bluetooth"
        const val KEY_VIBRATION = "key_vibration"
        const val KEY_DARK_MODE = "key_dark_mode"
    }

    private lateinit var binding: ActivitySettingBinding
    private var firstTime:Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {

            getSettings().filter{firstTime}.collect { settingsModel ->
                if(settingsModel != null){
                runOnUiThread{
                    binding.switchVibration.isChecked = settingsModel.vibration
                    binding.switchBluetooth.isChecked = settingsModel.bluetooth
                    binding.switchDarkMode.isChecked = settingsModel.darkMode
                    binding.rsVolume.setValues(settingsModel.volume.toFloat())
                    firstTime = !firstTime
                }

                }
            }
        }

        initUI()
    }


    private fun initUI() {
        //se pone barra baja si no necesitamos el valor
        binding.rsVolume.addOnChangeListener { _, value, _ ->
            Log.i("Apa", "el valor es $value")
            CoroutineScope(Dispatchers.IO).launch {
                saveVolumen(value.toInt())
            }
        }

            binding.switchBluetooth.setOnCheckedChangeListener { _, value ->
                CoroutineScope(Dispatchers.IO).launch {
                saveOptions("KEY_BLUETOOTH", value)
            }
        }
        binding.switchVibration.setOnCheckedChangeListener { _, value ->
            CoroutineScope(Dispatchers.IO).launch {
                saveOptions("KEY_VIBRATION", value)
            }
        }
        binding.switchDarkMode.setOnCheckedChangeListener { _, value ->

            if(value){
                enableDarkMode()
            }else{
                disableDarkMode()
            }

            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(KEY_DARK_MODE, value)
            }
        }
    }

    //para guardar datos. Se llama suspend porque necesita a una corrutina
    private suspend fun saveVolumen(value: Int) {
        //coge la bbdd y la edita
        dataStore.edit { preferences ->
            preferences[intPreferencesKey("VOLUME_LVL")] = value
        }

    }

    private suspend fun saveOptions(key: String, value: Boolean) {
        dataStore.edit { preferences ->
            preferences[booleanPreferencesKey(key)] = value

        }
    }

    private fun getSettings(): Flow<SettingsModel?> {
        return dataStore.data.map { preferences ->
            SettingsModel(
                volume = preferences[intPreferencesKey(VOLUME_LVL)] ?: 50,
                bluetooth = preferences[booleanPreferencesKey(KEY_BLUETOOTH)] ?: true,
                darkMode = preferences[booleanPreferencesKey(KEY_DARK_MODE)] ?: false,
                vibration = preferences[booleanPreferencesKey(KEY_VIBRATION)] ?: true
            )
        }
    }

    private fun enableDarkMode(){
        //Aplica el modo oscuro
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
        delegate.applyDayNight()
    }

    private fun disableDarkMode(){
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
        delegate.applyDayNight()
    }
}















