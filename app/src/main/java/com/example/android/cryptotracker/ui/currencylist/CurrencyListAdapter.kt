package com.example.android.cryptotracker.ui.currencylist


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.cryptotracker.R
import com.example.android.cryptotracker.data.model.Datum
import com.example.android.cryptotracker.databinding.ListItemBinding
import com.google.android.material.textview.MaterialTextView

class CurrencyListAdapter: ListAdapter<Datum, CurrencyListAdapter.ViewHolder>(CurrencyListDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder.from(parent)
    }


    class ViewHolder private constructor(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Datum) {
            binding.apply {
                datum = item
                executePendingBindings()
            }

        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)

            }
        }
    }


}



private class CurrencyListDiffCallback : DiffUtil.ItemCallback<Datum>() {

    override fun areItemsTheSame(oldItem: Datum, newItem: Datum): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Datum, newItem: Datum): Boolean {
        return oldItem == newItem
    }

}

@BindingAdapter("bindPrice")
fun bindPrice(view: MaterialTextView, double: Double) {
    view.text = String.format("%.2f", double)


}

@BindingAdapter("bindPercent")
fun bindPercent(view: MaterialTextView, double: Double) {
    String.format("%.2f", double).let {
        view.text = "$it%"

    }

}

@BindingAdapter("bindRank")
fun bindRank(view: MaterialTextView, int: Int) {
    view.text = int.toString()

}
