package com.example.kartrlanszckler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.fragment_siralama.*
import kotlinx.android.synthetic.main.fragment_yanlis_yapilan_kelimeler.*
import kotlinx.coroutines.launch

class SiralamaFragment : Fragment(R.layout.fragment_siralama) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            val responseGunlukSiralama = RetrofitProvider.newsApi.GunlukSiralamaGetir()
            val responseAylikSiralama = RetrofitProvider.newsApi.AylikSiralamaGetir()
            val responseGenelSiralama = RetrofitProvider.newsApi.GenelSiralamaGetir()

            buttonGunlukSiralama.setOnClickListener {
                textViewSiralamaBaslik.text = "GÜNLÜK SIRALAMA"
                recrecyclerview3.adapter = SiralamaDataAdapter(responseGunlukSiralama.orEmpty().toMutableList()) {
                }
            }


            buttonAylikSiralama.setOnClickListener {
                textViewSiralamaBaslik.text = "AYLIK SIRALAMA"
                recrecyclerview3.adapter = SiralamaDataAdapter(responseAylikSiralama.orEmpty().toMutableList()) {
                }
            }

            buttonGenelSiralama.setOnClickListener {
                textViewSiralamaBaslik.text = "GENEL SIRALAMA"
                recrecyclerview3.adapter = SiralamaDataAdapter(responseGenelSiralama.orEmpty().toMutableList()) {
                }
            }



        }

    }
}