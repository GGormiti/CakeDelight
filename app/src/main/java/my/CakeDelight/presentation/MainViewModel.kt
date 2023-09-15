package my.CakeDelight.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import my.CakeDelight.data.Cake
import my.CakeDelight.data.CakeRepositoryImpl
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: CakeRepositoryImpl
): ViewModel() {
    private var cakeLiveData: MutableLiveData<List<Cake>> = MutableLiveData()

    fun getLiveDataObserve(): MutableLiveData<List<Cake>>{
        return cakeLiveData
    }

    fun loadCakeList(){
        repository.getInfo(cakeLiveData)
    }
}