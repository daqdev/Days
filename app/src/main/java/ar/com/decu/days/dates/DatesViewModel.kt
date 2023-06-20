package ar.com.decu.days.dates

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.com.decu.days.dates.data.net.model.DatesModel
import ar.com.decu.days.dates.domain.GetDatesUseCase
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat

class DatesViewModel : ViewModel() {

    val formatter = SimpleDateFormat("dd-MM-yyyy")
    private var _result: MutableLiveData<DatesModel> = MutableLiveData<DatesModel>()
    val result: LiveData<DatesModel> = _result

    private val datesUseCase = GetDatesUseCase()

    fun loadDates() {
        if (_result.value == null) {
            viewModelScope.launch {
                val temp = datesUseCase()
                _result.value =
                    DatesModel(
                        formatter.format(temp.day30),
                        temp.days30,
                        formatter.format(temp.day90),
                        temp.days90,
                    )
            }
        }
    }
}