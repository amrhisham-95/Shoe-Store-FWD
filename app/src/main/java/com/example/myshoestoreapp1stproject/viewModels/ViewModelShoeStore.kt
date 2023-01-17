package com.example.myshoestoreapp1stproject.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myshoestoreapp1stproject.model.DataOfTheDetailsOfShoes

class ViewModelShoeStore : ViewModel() {

    //For Write the data from user by using MutableLiveData
     val mutableLiveDataWrite = MutableLiveData<List<DataOfTheDetailsOfShoes>>()

    init {
        mutableLiveDataWrite.value = mutableListOf()
    }

    //To put the data from the user in the detailScreen into a MutableList to store it
    fun addItems (dataItem:DataOfTheDetailsOfShoes) {
        mutableLiveDataWrite.value = mutableLiveDataWrite.value?.toMutableList()?.apply {add(dataItem)}
    }

}