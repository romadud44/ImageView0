package com.example.myapplicationtestsavedinstancestate

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel:ViewModel() {
    var number = 0
    val currentNumber: MutableLiveData<Int> by lazy{MutableLiveData<Int>()}
    }
