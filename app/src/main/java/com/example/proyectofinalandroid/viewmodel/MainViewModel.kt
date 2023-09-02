package com.example.proyectofinalandroid.viewmodel

import android.widget.EditText
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.proyectofinalandroid.model.Comparacion
import kotlinx.coroutines.launch


class MainViewModel:ViewModel() {
    val comparacion:LiveData<Comparacion> get() = _comparacion
    private var _comparacion=MutableLiveData<Comparacion>(Comparacion("","",""))
    var resultado:String=""

   fun comparar(et1:EditText, et2:EditText){

          if(et1.text.toString()==et2.text.toString()){
               resultado="Son iguales"
           }
          else{
               resultado="Son distintos"
       }

       updateComparacion(et1,et2,resultado)
   }

    private fun updateComparacion(et1:EditText,et2:EditText,resultado:String){
        viewModelScope.launch {
        _comparacion.value=Comparacion(et1.text.toString(),et2.text.toString(),resultado)
    }
    }
}