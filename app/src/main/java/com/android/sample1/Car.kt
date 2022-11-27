package com.android.sample1

import com.google.gson.annotations.SerializedName

data class Car(
    @SerializedName("num_models") val model: Int,
    @SerializedName("img_url") val image: String,
    @SerializedName("id") val id: Int,
    @SerializedName("avg_horsepower") val power: Double,
    @SerializedName("avg_price") val price: Double,
    @SerializedName("name") val name: String
)
