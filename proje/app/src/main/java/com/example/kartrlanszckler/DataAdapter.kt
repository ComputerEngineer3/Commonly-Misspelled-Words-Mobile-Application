package com.example.kartrlanszckler

import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kartrlanszckler.apiDataClasses.KelimelerClass
import kotlinx.android.synthetic.main.item_kelimeler.view.*

class DataAdapter(private val dataList :MutableList<KelimelerClass>, private val onClick: (KelimelerClass) -> Unit) :RecyclerView.Adapter<DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(parent.inflate(R.layout.item_kelimeler))
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val data = dataList[position]
        holder.bind(data, onClick)
    }

    override fun getItemCount(): Int = dataList.size

}

class DataViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    fun bind(data :KelimelerClass, onClick: (KelimelerClass) -> Unit) {
            itemView.textViewDogruYazilis.text = data.KelimeninDogrusu.toString()
            itemView.textViewYanlisYazilis.text = data.KelimeninYanlisi.toString()
    }
}