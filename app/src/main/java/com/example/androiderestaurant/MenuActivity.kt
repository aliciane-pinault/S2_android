package com.example.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request.Method
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.androiderestaurant.databinding.ActivityMenuBinding
import com.example.androiderestaurant.network.MenuResult
import com.example.androiderestaurant.network.NetworkConstants
import com.example.androiderestaurant.network.Plate
import com.google.gson.GsonBuilder
import org.json.JSONObject

enum class Category {STARTER, MAIN, DESSERT}
class MenuActivity : AppCompatActivity() {

        companion object{
            val extraKey = "extraKey"
        }
        lateinit var binding: ActivityMenuBinding
        lateinit var currentCategory: Category
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

            val category = intent.getSerializableExtra(extraKey) as? Category

            currentCategory = category ?: Category.STARTER

            supportActionBar?.title = categoryName()


            makeRequest()
    }

    private fun makeRequest(){
        val queue = Volley.newRequestQueue(this)
        val params = JSONObject()
        params.put(NetworkConstants.idShopKey, 1)
        val request = JsonObjectRequest(
            Method.POST,
            NetworkConstants.url,
            params,
            { result ->
                Log.d( "request", result.toString(2))
                parseData(result.toString())
            },
            { error->
                Log.e( "request", error.toString())
            }
        )
        queue.add(request)
    //showDatas()
    }

    private fun parseData(data: String){
        val result = GsonBuilder().create().fromJson(data, MenuResult::class.java)
        val category = result.data.first{it.name == categoryFilterKey()
        }
        Log.d( "request", "parsing")
        showDatas(category)
    }

    private fun showDatas(category: com.example.androiderestaurant.network.Category){
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = CustomerAdapter(category.items){
            //val intent = Intent( this, DetailActivity::class.java)
            val intent = Intent( this, PresActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("LifeCycle", "MenuActivity on Create")
    }

    private fun categoryName(): String{
        return when (currentCategory){
            Category.STARTER -> getString(R.string.starter)
            Category.MAIN -> getString(R.string.center)
            Category.DESSERT -> getString(R.string.finish)
        }

    }
    private fun categoryFilterKey(): String {
        return when(currentCategory){
            Category.STARTER -> "Entrées"
            Category.MAIN -> "Plats"
            Category.DESSERT -> "Desserts"
        }
    }

    override fun onDestroy() {
        Log.d( "onDestroy", "MenuActivity destroy")
        super.onDestroy()
    }
}
