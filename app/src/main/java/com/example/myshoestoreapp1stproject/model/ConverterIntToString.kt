package com.example.myshoestoreapp1stproject.model

import androidx.databinding.InverseMethod

//object To convert the Int To String Or String To Int (for the shoeSize in the detailScreen)
object ConverterIntToString {
    @InverseMethod("stringToInt")
    @JvmStatic
    fun intToString(value: Int?): String {
        return value?.toString() ?: ""
    }

    @JvmStatic
    fun stringToInt(value: String): Int? {
        return if (value.isNotEmpty()) {
            value.toInt()
        } else {
            0
        }
    }
}