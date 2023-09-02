package com.example.proyectofinalandroid.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyectofinalandroid.databinding.ActivityMainBinding
import androidx.activity.viewModels


import android.widget.EditText
import android.widget.Toast
import com.example.proyectofinalandroid.viewmodel.MainViewModel
import com.example.proyectofinalandroid.R

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.comparacion.observe(this){
            binding.textview1.text=it.resultado
        }

        binding.compareButton.setOnClickListener {
            validarIngreso()
         }
    }

     private fun validarIngreso() {
         val et1=findViewById<EditText>(R.id.edittext1)
         val et2=findViewById<EditText>(R.id.edittext2)

        if (et1.text.toString().isEmpty()){
            Toast.makeText(this, "Debe ingresar un texto o numero", Toast.LENGTH_SHORT).show()}
        else if (et2.text.toString().isEmpty()){
            Toast.makeText(this, "Debe ingresar un texto o numero", Toast.LENGTH_SHORT).show()}
        else{
            mainViewModel.comparar(et1,et2)}
        }

}

