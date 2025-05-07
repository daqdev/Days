package ar.com.decu.daysnews.dates.data.net.model

import com.google.gson.annotations.SerializedName

data class DatesModel(
    @SerializedName("btcPrice") val btcPrice: String,


    @SerializedName("day30") val day30: String,
    @SerializedName("days30") val days30: Number,
    @SerializedName("day90") val day90: String,
    @SerializedName("days90") val days90: Number
)