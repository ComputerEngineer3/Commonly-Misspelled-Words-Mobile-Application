package com.example.kartrlanszckler

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kartrlanszckler.apiDataClasses.YanlisKelimelerClass
import kotlinx.android.synthetic.main.item_yanliskelimeler.view.*

class YanlisKelimeDataAdapter(private val dataList :MutableList<YanlisKelimelerClass>, private val onClick: (YanlisKelimelerClass) -> Unit) : RecyclerView.Adapter<DataViewYanlisHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewYanlisHolder {
        return DataViewYanlisHolder(parent.inflate(R.layout.item_yanliskelimeler))
    }

    override fun onBindViewHolder(holder: DataViewYanlisHolder, position: Int) {
        val data = dataList[position]
        holder.bind(data, onClick)
    }

    override fun getItemCount(): Int = dataList.size

}

class DataViewYanlisHolder(view : View) : RecyclerView.ViewHolder(view) {
    fun bind(data: YanlisKelimelerClass, onClick: (YanlisKelimelerClass) -> Unit) {

        itemView.textViewDogruYazilisi.text = data.KelimeninDogrusu.toString()
        itemView.textViewYanlisYazilisi.text = data.KelimeninYanlisi.toString()


    }
}