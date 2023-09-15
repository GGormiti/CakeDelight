package my.CakeDelight.data

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CakeRepositoryImpl @Inject constructor(private val apiService: ApiService) {

    fun getInfo(liveData: MutableLiveData<List<Cake>>){
        val call: Call<CakeListResult> = apiService.getListCake()
        call.enqueue(object : Callback<CakeListResult> {
            override fun onResponse(
                call: Call<CakeListResult>,
                response: Response<CakeListResult>
            ) {
                if (response.isSuccessful){
                    liveData.postValue(response.body()?.cakeList)
                }
            }

            override fun onFailure(call: Call<CakeListResult>, t: Throwable) {
                liveData.postValue(null)
            }

        })
    }
}