package com.example.kartrlanszckler

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.coroutines.launch

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        buttonGirisYap.setOnClickListener {
            val kullaniciAdi = editTextUserName.text.toString()
            val sifre = editTextPassword.text.toString()

            lifecycleScope.launch {
                val responseOturum = RetrofitProvider.newsApi.OturumDogrulama(kullaniciAdi,sifre)
                if (responseOturum) {

                    val responseKullaniciId = RetrofitProvider.newsApi.GetKullanici(kullaniciAdi).KullanicininIDsi
                    Toast.makeText(this@LoginFragment.requireActivity(), "Giriş Başarılı...", Toast.LENGTH_LONG).show()

                    val destination = LoginFragmentDirections.actionLoginFragmentToMenuFragment(responseKullaniciId)
                    findNavController().navigate(destination)


                }
                else{
                    Toast.makeText(this@LoginFragment.requireActivity(), "Hatalı Giriş!!!", Toast.LENGTH_LONG).show()
                }
            }


        }


        buttonUyeOl.setOnClickListener {
            val destination = LoginFragmentDirections.actionLoginFragmentToKayitFragment()
            findNavController().navigate(destination)
        }


    }

}