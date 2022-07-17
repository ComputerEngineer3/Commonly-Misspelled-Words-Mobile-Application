package com.example.kartrlanszckler

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kartrlanszckler.apiDataClasses.SiralamaClass
import kotlinx.android.synthetic.main.item_siralamalar.view.*

class SiralamaDataAdapter(private val dataList :MutableList<SiralamaClass>, private val onClick: (SiralamaClass) -> Unit) : RecyclerView.Adapter<DataViewSiralamaHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewSiralamaHolder {
        return DataViewSiralamaHolder(parent.inflate(R.layout.item_siralamalar))
    }

    override fun onBindViewHolder(holder: DataViewSiralamaHolder, position: Int) {
        val data = dataList[position]
        holder.bind(data, onClick)
    }

    override fun getItemCount(): Int = dataList.size

}

class DataViewSiralamaHolder(view : View) : RecyclerView.ViewHolder(view) {
    fun bind(data: SiralamaClass, onClick: (SiralamaClass) -> Unit) {

        itemView.textView2.text = data.SiralamaNo.toString()
        itemView.textView3.text = data.KullaniciAdi.toString()
        itemView.textView4.text = data.Puan.toString()


    }
}