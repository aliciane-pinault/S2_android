package com.example.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.androiderestaurant.databinding.ActivityMenuBinding
import com.example.androiderestaurant.databinding.ActivityPresBinding
import com.example.androiderestaurant.network.MenuResult
import com.example.androiderestaurant.network.NetworkConstants
import com.example.androiderestaurant.network.Plate
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import org.json.JSONObject


class PresActivity : AppCompatActivity() {

    /*private lateinit var namePlate: String
    private lateinit var plate: Plate*/

    companion object{
        val extraKey = "extraKey"
    }

    lateinit var binding: ActivityPresBinding

    //private lateinit var binding: ActivityPresBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*setContentView(R.layout.activity_pres)
        plate = intent.getSerializableExtra("dish") as Plate*/

        binding = ActivityPresBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //supportActionBar?.title = plate.name.toString()

        //namePlate = plate.name.toString()

        /*val actionBar = supportActionBar
        actionBar?.title = namePlate*/

        /*val ingredients = plate.ingredients
        val ingredientString = StringBuilder()
        ingredients.forEach { ingredient ->
            ingredientString.append(ingredient.name)
            ingredientString.append("\n")
        }*/

        //makeRequest()

    }

    /*private fun makeRequest(){
        val queue = Volley.newRequestQueue(this)
        val params = JSONObject()
        params.put(NetworkConstants.idShopKey, 1)
        val request = JsonObjectRequest(
            Request.Method.POST,
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
    }*/

    /*private fun parseData(data: String){
        val result = GsonBuilder().create().fromJson(data, MenuResult::class.java)
        val category = result.data.first{it.name == namePlate
        }
        Log.d( "request", "parsing")
        //showDatas(category)
    }*/

    /*private fun showDatas(category: com.example.androiderestaurant.network.Category){
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = CustomerAdapter(category.items){
            //val intent = Intent( this, BasketActivity::class.java)
            startActivity(intent)
        }
    }*/

    override fun onStart() {
        super.onStart()
        Log.d("LifeCycle", "PresActivity on Create")
    }

    override fun onDestroy() {
        Log.d( "onDestroy", "PrsActivity destroy")
        super.onDestroy()
    }


}