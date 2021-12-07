package com.example.android.cryptotracker.data.network


import com.example.android.cryptotracker.BuildConfig
import com.example.android.cryptotracker.data.model.CurrencyList
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


const val coinMarketCapAPIKey = BuildConfig.API_KEY
private const val BASE_URL = "https://pro-api.coinmarketcap.com"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface CoinMarketCapApiService {

    @Headers("X-CMC_PRO_API_KEY:$coinMarketCapAPIKey")
    @GET("/v1/cryptocurrency/listings/latest?")
    suspend fun getCurrencyLists(
        @Query("limit") limit: String
    ): CurrencyList


}

object CoinMarketCapAPI {
    val RETROFIT_SERVICE: CoinMarketCapApiService by lazy {
        retrofit.create(CoinMarketCapApiService::class.java)
    }
}