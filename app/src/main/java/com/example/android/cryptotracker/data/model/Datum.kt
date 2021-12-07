package com.example.android.cryptotracker.data.model

import com.squareup.moshi.Json


//const val coinMarketCapAPIKey = "f463d1b1-f72e-41f2-8865-43d0e20f8fae"

data class CurrencyList(
    val status: Status,
    val data: List<Datum>
)

data class Datum (
    val id: Int,
    val name: String,
    val symbol: String,
    val slug: String,
    @Json(name = "cmc_rank") val cmcRank: Int,
    @Json(name = "num_market_pairs") val numMarketPairs: Int,
    @Json(name = "circulating_supply") val circulatingSupply: Double,
    @Json(name = "total_supply") val totalSupply: Double,
    @Json(name = "max_supply") val maxSupply: Double?,
    @Json(name = "last_updated") val lastUpdated: String,
    @Json(name = "date_added") val dateAdded: String,
    val tags: List<String> = emptyList(),
    val platform: Platform?,
    val quote: Quote
        )


data class Platform(
    val id: Int,
    val name: String,
    val symbol: String,
    @Json(name = "token_address") val tokenAddress: String
)

data class Quote(
    @Json(name = "USD") val uSD: USD
)

data class USD(
     val price: Double,
     @Json(name = "volume_24h") val volume24h: Double,
     @Json(name = "volume_change_24h") val volumeChange24h: Double,
     @Json(name = "percent_change_1h") val percentChange1h: Double,
     @Json(name = "percent_change_24h") val percentChange24h: Double,
     @Json(name = "percent_change_7d") val percentChange7d: Double,
     @Json(name = "market_cap") val marketCap: Double,
     @Json(name = "market_cap_dominance") val marketCapDominance: Double,
     @Json(name = "fully_diluted_market_cap") val fullyDilutedMarketCap: Double,
     @Json(name = "last_updated") val lastUpdated: String,

)

data class Status(
    @Json(name = "timestamp") val timeStamp: String,
    @Json(name = "error_code") val errorCode: Int,
    @Json(name = "error_message") val errorMessage: String?,
   val elapsed: Int,
    @Json(name = "credit_count") val creditCount: Int,
   val notice: String?,
    @Json(name = "total_count") val totalCount: Int,
)



