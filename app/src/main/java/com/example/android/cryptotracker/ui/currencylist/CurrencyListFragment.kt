package com.example.android.cryptotracker.ui.currencylist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.android.cryptotracker.R
import com.example.android.cryptotracker.data.model.Datum
import com.example.android.cryptotracker.data.model.Platform
import com.example.android.cryptotracker.data.model.Quote
import com.example.android.cryptotracker.data.model.USD
import com.example.android.cryptotracker.databinding.FragmentCurrencyListBinding


class CurrencyListFragment : Fragment() {
    private lateinit var binding: FragmentCurrencyListBinding
    private val viewModel: CurrencyListFragmentViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentCurrencyListBinding>(
            inflater, R.layout.fragment_currency_list,container,false).apply {
            lifecycleOwner = this@CurrencyListFragment
            viewmodel = viewModel
            list.adapter = CurrencyListAdapter()
        }

        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


  viewModel.currencyList.observe(viewLifecycleOwner, {
      Log.i("ResultFragment", "$it")
      it?.let { list ->
          (binding.list.adapter as CurrencyListAdapter).submitList(list)


    }

})

    }
}