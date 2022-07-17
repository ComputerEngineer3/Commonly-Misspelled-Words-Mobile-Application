package com.example.kartrlanszckler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_test_sonuc.*

class TestSonucFragment : Fragment(R.layout.fragment_test_sonuc) {

    private val navArgs by navArgs<TestSonucFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewDogruSayisi.text = navArgs.tsonucDogruS.toString()
        textViewYanlisSayisi.text = navArgs.tsonucYanlisS.toString()
        textViewPuan.text = navArgs.tsonucPuan.toString()

        if(navArgs.tsonucPuan >= 80) {
            textViewTestDegerlendirme.setText("MÜKEMMMEL!")
        }

        if(navArgs.tsonucPuan >=50 && navArgs.tsonucPuan<80) {
            textViewTestDegerlendirme.setText("FENA DEĞİL.")
        }

        if(navArgs.tsonucPuan < 50) {
            textViewTestDegerlendirme.setText("DAHA FAZLA DENEMELİSİN.")
        }


        buttonMenuyeDon.setOnClickListener {
            val testsonucId = navArgs.tsonuckId
            val direction = TestSonucFragmentDirections.actionTestSonucFragment5ToMenuFragment(testsonucId)
            findNavController().navigate(direction)
        }


    }
}