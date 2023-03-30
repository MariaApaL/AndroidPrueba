package com.apa.accenture.androidprueba.superheroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.apa.accenture.androidprueba.R
import com.apa.accenture.androidprueba.databinding.ActivitySuperHeroListBinding
import com.apa.accenture.androidprueba.superheroapp.DetailSuperheroActivity.Companion.EXTRA_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperHeroListActivity : AppCompatActivity() {
    //view binding
    private lateinit var binding:ActivitySuperHeroListBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter:SuperheroAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //antes del setcontent
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        // ANTES :  setContentView(R.layout.activity_super_hero_list)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()
    }

    private fun initUI() {
        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?) = false
        })

        adapter = SuperheroAdapter{ superheroId -> navegateToDetail(superheroId)}
        binding.rvSuperhero.setHasFixedSize(true)
        binding.rvSuperhero.layoutManager = LinearLayoutManager(this)
        binding.rvSuperhero.adapter = adapter
    }

    private fun searchByName(query: String) {

        binding.progressBar.isVisible = true;
        //corrutinas
        //SI queremos que ejecute en unhilo secundario (peticiones,guardar en bbdd, procesos muy largos..) se usa IO)
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<SuperheroDataResponse> = retrofit.create(ApiService::class.java).getSuperheroes(query)
            if(myResponse.isSuccessful) {
                val response: SuperheroDataResponse? = myResponse.body()

               if(response!= null){
                   Log.i("maria",response.toString())
                 //Ejecutar en el hilo principal (el UI siempre en el hilo principal)
                  runOnUiThread{
                      adapter.updateList(response.superheroes)
                      binding.progressBar.isVisible = false
                  }
               }
            }else{
                Log.i("maria"," no funciona")
            }
        }
    }

    //Crear objecto retrofit
    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun navegateToDetail(id:String){
        val intent = Intent(this,DetailSuperheroActivity::class.java)
        intent.putExtra(EXTRA_ID,id)
        startActivity(intent)
    }
}