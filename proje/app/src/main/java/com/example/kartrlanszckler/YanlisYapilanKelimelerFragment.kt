package com.example.kartrlanszckler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_kelimelere_goz_at.*
import kotlinx.android.synthetic.main.fragment_yanlis_yapilan_kelimeler.*
import kotlinx.android.synthetic.main.item_yanliskelimeler.*
import kotlinx.coroutines.launch

class YanlisYapilanKelimelerFragment : Fragment(R.layout.fragment_yanlis_yapilan_kelimeler) {

    private val navArgs by navArgs<YanlisYapilanKelimelerFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var responseYanlisSize = 0

        lifecycleScope.launch {
            val yanlisKelimeKullaniciId = navArgs.yanlisKelimelerkId
            val responseYanlisKelimeler = RetrofitProvider.newsApi.YanlisYapilanKelimeleriGetir(yanlisKelimeKullaniciId)
            responseYanlisSize = responseYanlisKelimeler.size


            recrecyclerview2.adapter = YanlisKelimeDataAdapter(responseYanlisKelimeler.orEmpty().toMutableList()) {
            }


        }


    }
}