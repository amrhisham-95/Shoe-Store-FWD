package com.example.myshoestoreapp1stproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.myshoestoreapp1stproject.R
import com.example.myshoestoreapp1stproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //To allow dataBinding instead of the findViewById()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


    }

    override fun onResume() {
        super.onResume()

        //To Add ToolBar(in ActionBar) for all fragments with appBarConfiguration
        setSupportActionBar(binding.toolbar)
        val navController = findNavController(R.id.fragment_host)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.loginScreen, R.id.listShoeScreen))
        binding.toolbar.setupWithNavController(navController,appBarConfiguration)
    }

    }




