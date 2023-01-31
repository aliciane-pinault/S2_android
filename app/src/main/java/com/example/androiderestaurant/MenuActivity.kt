package com.example.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
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

            val category = intent.getSerializableExtra(extraKey) as? Category

            supportActionBar?.title = categoryName(category ?:Category.STARTER)
            showDatas()
    }

    private fun showDatas(){
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = CustomerAdapter(listOf("1","2","3")){
            val intent = Intent( this, DetailActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("LifeCycle", "MenuActivity on Create")
    }

    private fun categoryName(category: Category): String{
        return when (category){
            Category.STARTER -> getString(R.string.starter)
            Category.MAIN -> getString(R.string.center)
            Category.DESSERT -> getString(R.string.finish)
        }

    }

    override fun onDestroy() {
        Log.d( "onDestroy", "MenuActivity destroy")
        super.onDestroy()
    }
}
