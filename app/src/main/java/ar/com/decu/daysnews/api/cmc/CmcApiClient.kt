package ar.com.decu.daysnews.api.cmc

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object CmcClient {
    private const val CMC_BASE_URL = "https://pro-api.coinmarketcap.com/"

    val api = Retrofit.Builder()
        .baseUrl(CMC_BASE_URL)
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

        .create(CmcService::class.java)
}
