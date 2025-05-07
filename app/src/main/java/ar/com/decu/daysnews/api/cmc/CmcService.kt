package ar.com.decu.daysnews.api.cmc

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CmcService {

    @GET("v1/cryptocurrency/listings/latest?start=1&limit=5000&convert=USD")
    suspend fun getData(): CmcModel

    fun provideCmcService(): CmcService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pro-api.coinmarketcap.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder().addInterceptor { chain ->
                    val request = chain.request().newBuilder()
                        .addHeader("X-CMC_PRO_API_KEY", "81484838-273b-4027-b938-aaaa49a5da4b")
                        .addHeader("Accept", "application/json")
                        .build()
                    chain.proceed(request)
                }.build()
            )
            .build()

        return retrofit.create(CmcService::class.java)
    }
}

