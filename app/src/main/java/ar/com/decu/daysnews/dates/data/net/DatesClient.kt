package ar.com.decu.daysnews.dates.data.net

import ar.com.decu.daysnews.dates.data.net.response.DatesResponse
import retrofit2.Response
import retrofit2.http.GET

interface DatesClient {
    @GET("/")
    suspend fun getDates(): Response<DatesResponse>
}