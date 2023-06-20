package ar.com.decu.days.dates.data.net

import ar.com.decu.days.core.net.RetrofitHelper
import ar.com.decu.days.dates.data.net.response.DatesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Date

class DatesService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getDates(): DatesResponse {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(DatesClient::class.java).getDates()
            response?.body() ?: DatesResponse(
                Date(),
                0,
                Date(),
                0
            )
        }
    }
}