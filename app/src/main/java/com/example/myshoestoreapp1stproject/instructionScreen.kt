package com.example.myshoestoreapp1stproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.myshoestoreapp1stproject.databinding.FragmentInstructionScreenBinding

class InstructionScreen : Fragment() {
   private lateinit var binding : FragmentInstructionScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment by using DataBinding
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_instruction_screen,container,false)

        // Using findNavController() to navigate From instructionScreen To listShoeScreen When Press the instructionsButton
        binding.instructionsButton.setOnClickListener {
            findNavController().navigate(R.id.action_instructionScreen_to_listShoeScreen)
        }
        return binding.root
    }

}