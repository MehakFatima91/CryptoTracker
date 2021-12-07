package com.example.android.cryptotracker.ui.currencydetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.android.cryptotracker.R
import com.example.android.cryptotracker.databinding.FragmentCurrencyDetailBinding
import com.example.android.cryptotracker.databinding.FragmentCurrencyListBinding

class CurrencyDetailFragment : Fragment() {
    private lateinit var binding: FragmentCurrencyDetailBinding
    private val viewModel: CurrencyDetailFragmentViewModel by viewModels()
   

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentCurrencyDetailBinding>(
            inflater, R.layout.fragment_currency_detail,container,false).apply {
            lifecycleOwner = this@CurrencyDetailFragment
            viewmodel = viewModel
        }

        return binding.root
    }
    
}