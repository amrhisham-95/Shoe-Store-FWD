package com.example.myshoestoreapp1stproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.myshoestoreapp1stproject.R
import com.example.myshoestoreapp1stproject.databinding.FragmentLoginScreenBinding


class LoginScreen : Fragment() {

   private lateinit var binding : FragmentLoginScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment by using DataBinding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login_screen,container,false)

        // Using findNavController() to navigate From loginScreen To welcomeScreen When Press the buttonCreateALogin
        binding.buttonCreateALogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginScreen_to_welcomeScreen)
        }

        // Using findNavController() to navigate From loginScreen To welcomeScreen When Press the buttonLogin
        binding.buttonLogin.setOnClickListener{
            findNavController().navigate(R.id.action_loginScreen_to_welcomeScreen)
        }


        return binding.root
    }

}

