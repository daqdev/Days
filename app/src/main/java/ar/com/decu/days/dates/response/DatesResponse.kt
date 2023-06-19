package ar.com.decu.days.dates.response

import com.google.gson.annotations.SerializedName
import java.util.Date


data class DatesResponse(
    @SerializedName("day30") val day30: Date,
    @SerializedName("days30") val days30: Number,
    @SerializedName("day90") val day90: Date,
    @SerializedName("days90") val days90: Number
) {

}
