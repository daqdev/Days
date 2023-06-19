package ar.com.decu.days.core.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://hfqipj3meon6d5j5m46egre3na0xavow.lambda-url.us-east-1.on.aws/")
            .addConverterFactory(GsonConverterFactory.create()  )
            .build()
    }
}