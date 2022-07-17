package com.example.kartrlanszckler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.fragment_kelimelere_goz_at.*
import kotlinx.coroutines.launch

class KelimelereGozAtFragment : Fragment(R.layout.fragment_kelimelere_goz_at) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        lifecycleScope.launch {

            val responseKelimeler = RetrofitProvider.newsApi.KelimeleriGetir()
                recrecyclerview.adapter = DataAdapter(responseKelimeler.orEmpty().toMutableList()) {
            }


        }

        buttonAra.setOnClickListener {
            val aranacakKelimeler = editTextAranacakKelime.text.toString()
            lifecycleScope.launch {
                val responseAranacakKelimeler = RetrofitProvider.newsApi.ArananKelimeleriGetir(aranacakKelimeler)

                recrecyclerview.adapter = DataAdapter(responseAranacakKelimeler.orEmpty().toMutableList()){

                }

            }
        }

    }
}