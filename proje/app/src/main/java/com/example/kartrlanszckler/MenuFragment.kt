package com.example.kartrlanszckler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_menu.*
import kotlinx.coroutines.launch

class MenuFragment : Fragment(R.layout.fragment_menu) {

    private val navArgs by navArgs<MenuFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        buttonGozat.setOnClickListener {
            val destination = MenuFragmentDirections.actionMenuFragmentToKelimelereGozAtFragment()
            Navigation.findNavController(it).navigate(destination)
        }


        buttonYanlisKelimeler.setOnClickListener {
            val kullaniciId = navArgs.menukId
            val destination = MenuFragmentDirections.actionMenuFragmentToYanlisYapilanKelimelerFragment(kullaniciId)
            findNavController().navigate(destination)
        }





        buttonSiralama.setOnClickListener {
            val destination = MenuFragmentDirections.actionMenuFragmentToSiralamaFragment()
            findNavController().navigate(destination)
        }

        buttonBasla.setOnClickListener {
            val kullaniciId = navArgs.menukId
            val destination = MenuFragmentDirections.actionMenuFragmentToTestFragment4(kullaniciId, 1, 20)
            findNavController().navigate(destination)
        }

    }

}