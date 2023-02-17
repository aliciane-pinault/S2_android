package com.example.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androiderestaurant.databinding.CellCustomBinding
import com.example.androiderestaurant.network.Plate
import com.squareup.picasso.Picasso

class PresAdapterActivity(val items : List<Plate>, val clickListener: (Plate) -> Unit) : RecyclerView.Adapter<PresAdapterActivity.CellViewHolder>() {

    class CellViewHolder(binding: CellCustomBinding): RecyclerView.ViewHolder(binding.root){
        val presImageView = binding.imageView //id du recycle view dans cell custom
        /*val add = binding.add
        val less = binding.less
        val quantity = binding.quantity*/
        val ingredientsTextView= binding.recycle
        val namepresTextView = binding.recycle
        val root = binding.root

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CellViewHolder {
        val binding = CellCustomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return(CellViewHolder(binding))
    }

    override fun getItemCount(): Int {
        return items.count()

    }

    override fun onBindViewHolder(holder: CellViewHolder, position: Int) {
        val plate = items[position]
        holder.namepresTextView.text = plate.name
       // holder.ingredientsTextView.text = plate.ingredients
        Picasso.get().load(getThumbnail(plate)).into(holder.presImageView)
        holder.root.setOnClickListener {
            Log.d("achat", "click on ${position+1}")
            clickListener(plate)
        }
    }

    private fun getThumbnail (plate: Plate): String? { //pour gérer ls erreurs si jamais il n'y a pas d'image ou de nom
        return if (plate.images.isNotEmpty()&& plate.images.firstOrNull()?.isNotEmpty() == true) {
            plate.images.firstOrNull()
        } else{
            null
        }
    }



}
