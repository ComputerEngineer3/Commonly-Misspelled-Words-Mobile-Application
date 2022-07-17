package com.example.kartrlanszckler

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.navigation.NavController
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.kartrlanszckler.apiDataClasses.KelimelerClass
import com.example.kartrlanszckler.apiDataClasses.YanlisKelimelerClass
import kotlinx.android.synthetic.main.fragment_test.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class TestFragment : Fragment(R.layout.fragment_test) {

    private val navArgs by navArgs<TestFragmentArgs>()
    private var dogruSayisi = 0
    private var yanlisSayisi = 0
    var sayac = 0
    var butonText = ""
    var sorularBittiMi = false
    lateinit var responseTestKelimeleri :List<KelimelerClass>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {

                responseTestKelimeleri = RetrofitProvider.newsApi.TestIcinKelimeleriGetir()

            soruIslemleri(responseTestKelimeleri, sayac)



        }


        buttonCevap1.setOnClickListener {
            lifecycleScope.launch {
                butonText = buttonCevap1.text.toString()

                if(butonText == responseTestKelimeleri[sayac].KelimeninDogrusu){
                    dogruSayisi = dogruSayisi + 1
                    Toast.makeText(this@TestFragment.requireActivity(), "Doğru", Toast.LENGTH_SHORT).show()

                }

                else{
                    val testtKullaniciId = navArgs.testkId
                    val kelimeIdsi = responseTestKelimeleri[sayac].KelimeID
                    yanlisSayisi = yanlisSayisi + 1
                    Toast.makeText(this@TestFragment.requireActivity(), "Yanlış", Toast.LENGTH_SHORT).show()

                    val responseSonuc = RetrofitProvider.newsApi.YanlisYapilanKelimeEkle(testtKullaniciId, kelimeIdsi!!.toInt())

                }




                sayac = sayac + 1
                if(sayac < 20){
                    soruIslemleri(responseTestKelimeleri, sayac)
                }
                else{
                    val testtKullaniciId = navArgs.testkId
                    val testPuan = ((dogruSayisi*5)-(yanlisSayisi*2))
                    RetrofitProvider.newsApi.GenelSiralamaEkle(testtKullaniciId, dogruSayisi, yanlisSayisi, testPuan)
                    val destination = TestFragmentDirections.actionTestFragment4ToTestSonucFragment5(dogruSayisi, yanlisSayisi, testPuan, testtKullaniciId)
                    findNavController().navigate(destination)
                }
            }
        }

        buttonCevap2.setOnClickListener {
            lifecycleScope.launch {
                butonText = buttonCevap2.text.toString()

                if(butonText == responseTestKelimeleri[sayac].KelimeninDogrusu){
                    dogruSayisi = dogruSayisi + 1
                    Toast.makeText(this@TestFragment.requireActivity(), "Doğru", Toast.LENGTH_SHORT).show()

                }

                else{
                    val testtKullaniciId = navArgs.testkId
                    val kelimeIdsi = responseTestKelimeleri[sayac].KelimeID
                    yanlisSayisi = yanlisSayisi + 1
                    Toast.makeText(this@TestFragment.requireActivity(), "Yanlış", Toast.LENGTH_SHORT).show()

                    val responseSonuc = RetrofitProvider.newsApi.YanlisYapilanKelimeEkle(testtKullaniciId, kelimeIdsi!!.toInt())

                }




                sayac = sayac + 1
                if(sayac < 20){
                    soruIslemleri(responseTestKelimeleri, sayac)
                }
                else{
                    val testtKullaniciId = navArgs.testkId
                    val testPuan = ((dogruSayisi*5)-(yanlisSayisi*2))
                    RetrofitProvider.newsApi.GenelSiralamaEkle(testtKullaniciId, dogruSayisi, yanlisSayisi, testPuan)
                    val destination = TestFragmentDirections.actionTestFragment4ToTestSonucFragment5(dogruSayisi, yanlisSayisi, testPuan, testtKullaniciId)
                    findNavController().navigate(destination)
                }
            }
        }


    }


    fun soruIslemleri(kelimeList : List<KelimelerClass>, sayac:Int) {

        buttonCevap1.setBackgroundColor(Color.parseColor("#8D7688"))
        buttonCevap2.setBackgroundColor(Color.parseColor("#8D7688"))
        var randomSayi = (1..2).random()

        if (randomSayi == 1) {
            buttonCevap1.setText(kelimeList[sayac].KelimeninDogrusu)
            buttonCevap2.setText(kelimeList[sayac].KelimeninYanlisi)
        }

        if(randomSayi == 2){
            buttonCevap1.setText(kelimeList[sayac].KelimeninYanlisi)
            buttonCevap2.setText(kelimeList[sayac].KelimeninDogrusu)
        }


    }



    /*fun cevabiKontrolEt(kelimeList : List<KelimelerClass>, buton:Button){

        butonText = buton.text.toString()

        if(butonText == kelimeList[sayac].KelimeninDogrusu){
            dogruSayisi = dogruSayisi + 1
            Toast.makeText(this@TestFragment.requireActivity(), "Doğru", Toast.LENGTH_SHORT).show()

        }

        else{
            yanlisSayisi = yanlisSayisi + 1
            Toast.makeText(this@TestFragment.requireActivity(), "Yanlış", Toast.LENGTH_SHORT).show()
        }
    }*/

}