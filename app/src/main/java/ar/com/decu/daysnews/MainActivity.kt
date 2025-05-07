package ar.com.decu.daysnews

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import ar.com.decu.daysnews.api.cmc.CmcService
import ar.com.decu.daysnews.api.cmc.CmcViewModel
import ar.com.decu.daysnews.api.cmc.CmcViewModelFactory
import ar.com.decu.daysnews.dates.DatesViewModel
import ar.com.decu.daysnews.dates.ui.DaysScreen
import ar.com.decu.daysnews.ui.theme.DaysTheme
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("API_RESPONSE", 123.toString())

        setContent {
            DaysTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppContent()

                }
            }
        }
    }

    @Composable
    fun AppContent() {
        val datesViewModel: DatesViewModel = viewModel()

        val service = remember { provideCmcService() }
        val factory = remember { CmcViewModelFactory(service) }
        val cmcViewModel: CmcViewModel = viewModel(factory = factory)


        Log.d("AppContent", " AppContent")

        LaunchedEffect(Unit) {
            datesViewModel.loadDates()
        }


        DaysScreen(datesViewModel, cmcViewModel)

    }

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
    }}
