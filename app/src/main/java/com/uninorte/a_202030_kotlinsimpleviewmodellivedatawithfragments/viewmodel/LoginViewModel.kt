package com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LoginViewModel : ViewModel() {
    var logged = MutableLiveData<Boolean>()
    var stateLogged : Boolean = false

    init {
        stateLogged = false
        logged.value = stateLogged;
    }

    fun getLogged() = logged as LiveData<Boolean>

    fun setLogged(state: Boolean){
        stateLogged = state
        logged.value = stateLogged;
    }
}
