package com.example.myshoestoreapp1stproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.myshoestoreapp1stproject.databinding.FragmentDetailShoeScreenBinding
import com.example.myshoestoreapp1stproject.model.DataOfTheDetailsOfShoes
import com.example.myshoestoreapp1stproject.viewModels.ViewModelShoeStore

class DetailShoeScreen : Fragment() {
    private lateinit var binding: FragmentDetailShoeScreenBinding
    //explain viewModel Class
    private val viewModelShoe : ViewModelShoeStore by activityViewModels()
    //explain data class
    private var dataOfTheShoe = DataOfTheDetailsOfShoes()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment by using DataBinding
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail_shoe_screen,container,false)

        // Using findNavController() to returns back From detailShoeScreen To listShoeScreen When Press the cancelButton
        binding.cancelButton.setOnClickListener {
            findNavController().navigateUp()
        }

        // Using findNavController() to returns Back From detailShoeScreen To listShoeScreen When Press the saveButton And Returns The Data that added in the editTexts at the detailShoeScreen to the listShoeScreen for Displaying its on the linearLayout
        binding.saveButton.setOnClickListener {
            viewModelShoe.addItems(dataOfTheShoe)
            findNavController().navigateUp()
        }


        //To make the data binding lifecycle aware
         binding.lifecycleOwner= this
        //put variable(dataShoe) in the xml file of the detailScreen equal variable (dataOfTheShoe) that initialized from dataClass
         binding.dataShoe = dataOfTheShoe


        return binding.root
    }

}