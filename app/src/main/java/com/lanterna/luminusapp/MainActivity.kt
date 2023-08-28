package com.lanterna.luminusapp

import android.hardware.camera2.CameraManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lanterna.luminusapp.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var estado = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lanterna.setOnClickListener {

            if(!estado) {
                //setImage Change Img
                binding.lanterna.setImageResource(R.drawable.ic_lanterna_ligada)
                estado = true
                lightLanterna(estado)
            } else {
                binding.lanterna.setImageResource(R.drawable.ic_lanterna_desligada)
                estado = false
                lightLanterna(estado)
            }
        }
    }

    private fun lightLanterna(estado: Boolean) {

        //Herdando o serviço de camera
        val camManager: CameraManager = getSystemService(CAMERA_SERVICE) as CameraManager
        //Representar camera frontal ou trazeira
        val cameraId: String?

        try {
            //Trazeira: 0 Frontal: 1
            cameraId = camManager.cameraIdList[0]
            camManager.setTorchMode(cameraId, estado)
        }catch (e: Exception) {

        }

    }
}