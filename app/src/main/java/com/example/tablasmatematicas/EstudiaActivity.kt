package com.example.tablasmatematicas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_estudia.*
import kotlinx.android.synthetic.main.activity_main.*

class EstudiaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estudia)

        btnsalirestudia.setOnClickListener {
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }

        var listaElementos = mutableListOf<String>()//este es el tipo de datos correcto


        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

                listaElementos.clear()//aquí limpio la lista
                if (p1 < 1){
                    seekBar.setProgress(1)
                }
                if (p1 > 0){
                    for(i in 1..10){
                        val texto = "$p1 x $i = ${p1*i}"
                        listaElementos.add(texto)//aquí añado el nuevo elemento
                    }
                }


                val adaptador = ArrayAdapter(application,android.R.layout.simple_list_item_1,listaElementos)
                listaTablas.adapter = adaptador
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })


    }
}