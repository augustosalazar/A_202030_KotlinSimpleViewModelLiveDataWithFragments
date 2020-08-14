package com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.util

import android.content.Context
import android.content.SharedPreferences

class PreferenceProvider(context: Context) {

    private val appContext = context.applicationContext

    private val preference : SharedPreferences
        get() = appContext.getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE)

    fun setValue(value: String){
        preference.edit().putString("key",value)
    }

    fun getValue(): String? {
        return preference.getString("key",null)
    }
}