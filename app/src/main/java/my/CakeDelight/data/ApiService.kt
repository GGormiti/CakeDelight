package my.CakeDelight.data

import my.CakeDelight.data.CakeListResult
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/api/json/v1/1/search.php?s=cake")
    fun getListCake(): Call<CakeListResult>
}