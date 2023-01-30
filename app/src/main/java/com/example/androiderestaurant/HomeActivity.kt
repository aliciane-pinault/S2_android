package com.example.androiderestaurant

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.androiderestaurant.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonsListener()
        }
        private fun buttonsListener(){
            binding.start.setOnClickListener {
                Log.d( "button", "Click sur button starter")
                Toast.makeText(this, "entrées", Toast.LENGTH_LONG ).show()
            }
            binding.center.setOnClickListener {
                Log.d( "button", "Click sur button center")
                Toast.makeText(this, "plats", Toast.LENGTH_LONG ).show()
            }
            binding.fin.setOnClickListener {
                Log.d( "button", "Click sur button finish")
                Toast.makeText(this, "desserts", Toast.LENGTH_LONG ).show()
            }
        }


    }