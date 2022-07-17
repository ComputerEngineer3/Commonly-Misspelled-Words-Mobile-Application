package com.example.kartrlanszckler

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_kayit.*
import kotlinx.coroutines.launch

class KayitFragment : Fragment(R.layout.fragment_kayit) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        buttonKayitOl.setOnClickListener {
            val uyeIsmi = editTextUyeIsmi.text.toString()
            val uyeSifresi = editTextUyeSifresi.text.toString()
            val uyeSifresi2 = editTextUyeSifresi2.text.toString()
            val uyeYas = editTextYas.text.toString().toInt()

            lifecycleScope.launch {
                if(uyeSifresi == uyeSifresi2){
                    val responseKayitDogrulama = RetrofitProvider.newsApi.UyeOl(uyeIsmi,uyeSifresi,uyeYas)
                    if(responseKayitDogrulama){
                        Toast.makeText(this@KayitFragment.requireActivity(), "Kayıt Başarılı.", Toast.LENGTH_LONG).show()
                        findNavController().navigate(R.id.action_kayitFragment_to_loginFragment)
                    }
                    else{
                        Toast.makeText(this@KayitFragment.requireActivity(), "Kayıt Başarısız!!!", Toast.LENGTH_LONG).show()
                    }
                }
                else{
                    Toast.makeText(this@KayitFragment.requireActivity(), "Şifreler Uyuşmuyor!!!", Toast.LENGTH_LONG).show()
                }

            }

        }


    }
}