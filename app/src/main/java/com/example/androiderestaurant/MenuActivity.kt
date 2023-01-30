package com.example.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androiderestaurant.databinding.ActivityMenuBinding

enum class Category {STARTER, MAIN, DESSERT}
class MenuActivity : AppCompatActivity() {

        companion object{
            val extraKey = "extraKey"
        }
        lateinit var binding: ActivityMenuBinding
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
            Log.d("LifeCycle", "MenuActivity on Create")
    }

    override fun onDestroy() {
        Log.d( "onDestroy", "MenuActivity destroy")
        super.onDestroy()
    }
}
