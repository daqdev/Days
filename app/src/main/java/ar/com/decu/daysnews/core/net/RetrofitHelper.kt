package ar.com.decu.daysnews.core.net

import retrofit2.Retrofit

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .build()
    }
}