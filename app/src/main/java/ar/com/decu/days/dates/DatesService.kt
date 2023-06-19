package ar.com.decu.days.dates

import ar.com.decu.days.core.net.RetrofitHelper
import ar.com.decu.days.dates.response.DatesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.DateTimeException

class DatesService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getDates(): DatesResponse {
        return withContext(Dispatchers.IO) {

            val response = retrofit.create(DatesClient::class.java).getDates()
            val dates = response.body() as DatesResponse
//            uiThread{
//                if(dates.day30 != null){
//                    initCharacter()
//                }
//            }
//            response.body()?.day30 ?: null
        }

    }
}