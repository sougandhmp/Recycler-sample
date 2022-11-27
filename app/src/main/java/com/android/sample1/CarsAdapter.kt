package com.android.sample1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlin.math.roundToInt

class CarsAdapter(private val cars:List<Car>,private val context : Context) : RecyclerView.Adapter<CarsAdapter.CarsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cars_card, parent, false)
        return CarsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
        val currentCar = cars[position]
        Glide.with(context).load(currentCar.image).into(holder.image)
        holder.name.text = currentCar.name.uppercase()
        "Power : ${currentCar.power.roundToInt()} HP".also { holder.power.text = it }
        "Price : ${currentCar.price.roundToInt()} $".also { holder.price.text = it }
    }

    override fun getItemCount(): Int = cars.size

    class CarsViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.imageView)
        val name: TextView = view.findViewById(R.id.name_text)
        val power: TextView = view.findViewById(R.id.power_text)
        val price: TextView = view.findViewById(R.id.price_text)
    }
}