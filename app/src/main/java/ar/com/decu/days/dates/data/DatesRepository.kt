package ar.com.decu.days.dates.data

import android.util.Log
import ar.com.decu.days.dates.data.net.DatesService
import ar.com.decu.days.dates.data.net.response.DatesResponse

class DatesRepository {
    private val api = DatesService()

    suspend fun getDates(): DatesResponse {
        Log.i("LLAMADA AL WS","LLAMADA AL WS")
        return api.getDates().copy()
    }
}