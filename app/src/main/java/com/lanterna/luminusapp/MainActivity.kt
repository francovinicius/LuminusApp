package com.lanterna.luminusapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.lanterna.luminusapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var estado = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lanterna.setOnClickListener {

            if(!estado) {
                //setImage para alterar a imagem da lanterna
                binding.lanterna.setImageResource(R.drawable.ic_lanterna_ligada)
                estado = true
            } else {
                binding.lanterna.setImageResource(R.drawable.ic_lanterna_desligada)
                estado = false
            }
        }
    }
}