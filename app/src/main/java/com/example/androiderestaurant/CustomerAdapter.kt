package com.example.androiderestaurant

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView.OnChildClickListener
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.androiderestaurant.databinding.CellCustomBinding
import kotlin.math.log

class CustomerAdapter(val items : List<String>, val clickListener: (Int) -> Unit) : RecyclerView.Adapter<CustomerAdapter.CellViewHolder>(){
    class CellViewHolder(binding: CellCustomBinding): RecyclerView.ViewHolder(binding.root){
        val textView: TextView = binding.recycle //id du recycle view dans cell custom
        val root: ConstraintLayout = binding.root

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CellViewHolder {
        val binding = CellCustomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return(CellViewHolder(binding))
    }

    override fun getItemCount(): Int {
        return items.count()

    }

    override fun onBindViewHolder(holder: CellViewHolder, position: Int) {
        holder.textView.text = items[position]
        holder.textView.setOnClickListener {
            Log.d("click", "click on ${position+1}")
            clickListener(position)
        }

    }



}