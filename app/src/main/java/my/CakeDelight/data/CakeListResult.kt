package my.CakeDelight.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CakeListResult(
    @SerializedName("meals")
    val cakeList: List<Cake>
): Serializable
