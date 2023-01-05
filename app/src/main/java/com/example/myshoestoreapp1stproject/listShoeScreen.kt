package com.example.myshoestoreapp1stproject

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.example.myshoestoreapp1stproject.databinding.FragmentListShoeScreenBinding
import com.example.myshoestoreapp1stproject.viewModels.ViewModelShoeStore


class ListShoeScreen : Fragment() {

    private lateinit var binding: FragmentListShoeScreenBinding

    //Define viewModel Class and put it accessible with two-Way DataBinding
    private val viewModelShoe: ViewModelShoeStore by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment by using DataBinding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_shoe_screen, container, false)


        // Using findNavController() to navigate From listShoeScreen To detailShoeScreen When Press the floatingActionButton
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listShoeScreen_to_detailShoeScreen)
        }

        //To Add Options Menu to the toolbar in the listShoeScreen , this Method I used because (onOptionMenu & onItemSelectedMenu) are deprecated
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_listscreen, menu)
            }

            //To Do action "navigate" from listShoeScreen to loginScreen when user is press on item"LOGOUT" in menu
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.logout_menu -> {
                        findNavController().navigateUp()
                        return true
                    }
                    else -> {
                        false
                    }
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)


        //Observation on the liveDataRead in the viewModel,if changes happen at the detailScreen when the user put the data in the editTexts,return these data to the listScreen when user press on SaveButton
        viewModelShoe.liveDataRead.observe(viewLifecycleOwner) {

            val listData: ArrayList<String> = ArrayList()

            for (i in it) {
                val name = "Name: ("+i.name+")"
                val company = "Company: ("+i.company+")"
                val size = "Size: ("+i.shoeSize+")"
                val description ="Description: ("+ i.descriptions+")"

                //put the data at the data class into listData arrayList
                listData.add(0,name)
                listData.add(1,company)
                listData.add(2,size)
                listData.add(3,description)


                    val text = TextView(requireContext())
                    text.text = listData[0]+"\n"+listData[1]+"\n"+listData[2]+"\n"+listData[3]+"\n"
                    text.layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )

                    binding.linearLayout1.addView(text)

            }
        }
        return binding.root
    }
}





