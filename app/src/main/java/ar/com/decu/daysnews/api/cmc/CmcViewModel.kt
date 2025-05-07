package ar.com.decu.daysnews.api.cmc

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CmcViewModel(private val service: CmcService) : ViewModel() {

    var apiData by mutableStateOf<CmcModel?>(null)
        private set

    init {
        viewModelScope.launch {
            apiData = service.getData()
            Log.d("API_RESPONSE", apiData.toString())
            Log.d("API_RESPONSE", apiData.toString())

        }
    }

}

class CmcViewModelFactory(private val service: CmcService) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CmcViewModel::class.java)) {
            return CmcViewModel(service) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}