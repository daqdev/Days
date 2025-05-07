package ar.com.decu.daysnews.dates.data

import ar.com.decu.daysnews.dates.data.net.DatesService
import ar.com.decu.daysnews.dates.data.net.response.DatesResponse

class DatesRepository {
    private val api = DatesService()

    suspend fun getDates(): DatesResponse {
        return api.getDates().copy()
    }
}