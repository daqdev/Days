package ar.com.decu.days.dates

import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ar.com.decu.days.dates.data.net.model.DatesModel
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class DatesViewModel : ViewModel() {

    private var _result: MutableLiveData<DatesModel> = MutableLiveData<DatesModel>()
    val result: LiveData<DatesModel> = _result

    fun loadDates() {

        if (_result.value == null) {

            val requiredDayOfWeek = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                DayOfWeek.FRIDAY
            } else {
                TODO("VERSION.SDK_INT < O")
            }
            val localdate = LocalDate.now()

            var ld30 = localdate.plusDays(30)
            while (ld30.dayOfWeek != requiredDayOfWeek) {
                ld30 = ld30.plusDays(1)
            }
            val totalDays30 = ChronoUnit.DAYS.between(localdate, ld30)

            var ld90 = localdate.plusDays(90)
            while (ld90.dayOfWeek != requiredDayOfWeek) {
                ld90 = ld90.plusDays(1)
            }
            val totalDays90 = ChronoUnit.DAYS.between(localdate, ld90)

            _result.value =
                DatesModel(
                    ld30.toString(),
                    totalDays30,
                    ld90.toString(),
                    totalDays90,
                )
        }
    }
}
