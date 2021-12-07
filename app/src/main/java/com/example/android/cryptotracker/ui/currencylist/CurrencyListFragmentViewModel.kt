package com.example.android.cryptotracker.ui.currencylist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.cryptotracker.data.model.Datum
import com.example.android.cryptotracker.data.model.Platform
import com.example.android.cryptotracker.data.model.Quote
import com.example.android.cryptotracker.data.model.USD
import com.example.android.cryptotracker.data.network.CoinMarketCapAPI
import kotlinx.coroutines.launch

class CurrencyListFragmentViewModel: ViewModel() {

    init {
        getCurrencyList()
    }


    private val _currencyList = MutableLiveData<List<Datum>>()
    val currencyList: LiveData<List<Datum>> = _currencyList


    private fun getCurrencyList() {
        viewModelScope.launch {
            try {
                val listResult = CoinMarketCapAPI.RETROFIT_SERVICE.getCurrencyLists("100")
                _currencyList.value = listResult.data
                Log.i("Result", "$listResult")
            } catch (e:Exception) {
                Log.i("Error", "${e.message}")
            }


        }
    }
}