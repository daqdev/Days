package ar.com.decu.daysnews.dates

import android.os.Build
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import ar.com.decu.daysnews.dates.data.net.model.DatesModel
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class DatesViewModel : ViewModel() {

    var _result by mutableStateOf(DatesModel("", "", 0, "", 0))
        private set

    val result: DatesModel get() = _result

    fun loadDates() {

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
        Log.d("API_RESPONSE", ld30.toString())
        _result = _result.copy(
            "",
            ld30.toString(),
            totalDays30,
            ld90.toString(),
            totalDays90,
        )
    }

}
