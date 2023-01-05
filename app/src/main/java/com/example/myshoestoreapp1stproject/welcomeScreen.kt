package com.example.myshoestoreapp1stproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.myshoestoreapp1stproject.databinding.FragmentWelcomeScreenBinding

class WelcomeScreen : Fragment() {
    private lateinit var binding : FragmentWelcomeScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment by using DataBinding
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_welcome_screen,container,false)

        // Using findNavController() to navigate From welcomeScreen To instructionScreen When Press the button in the welcomeScreen
        binding.button.setOnClickListener {
          findNavController().navigate(R.id.action_welcomeScreen_to_instructionScreen)
        }
        return binding.root
    }

}