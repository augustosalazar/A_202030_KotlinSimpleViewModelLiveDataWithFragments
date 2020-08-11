package com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.uninorte.a_2020_bindingclick.data.User
import com.uninorte.a_2020_kotlinsimpleviewmodellivedatavideo.MyViewModel
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment() {

    private var userList = mutableListOf<User>()
    lateinit var myViewModel : MyViewModel
    var count : Int = 0

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // get the instance of the ViewModel
        myViewModel = ViewModelProvider(this). get(MyViewModel::class.java)

        // get the live data and start observing
        myViewModel.getUsers().observe(getViewLifecycleOwner(), Observer { users ->
            run {
                textViewSize.text = ""+users.size
                count  = users.size
                userList = users as MutableList<User>
                users.forEach{ user ->
                    Log.d("VideoViewModel", user.name + "  "+ user.age)
                }
                Log.d("VideoViewModel", "" + users.size)
            }
        })

        view.findViewById<Button>(R.id.button).setOnClickListener {
            myViewModel.addUser(User("TestUser", userList.size+20))
        }
    }
}