package com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.R
import com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.viewmodel.LoginViewModel
import com.uninorte.a_2020_bindingclick.data.User
import com.uninorte.a_2020_kotlinsimpleviewmodellivedatavideo.MyViewModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private var userList = mutableListOf<User>()
    lateinit var myViewModel : MyViewModel
    val loginViewModel: LoginViewModel by activityViewModels()
    var count : Int = 0

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
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

        val navController = findNavController()
        loginViewModel.getLogged().observe(viewLifecycleOwner, Observer { logged ->
            if (logged == false) {
                navController.navigate(R.id.LoginFragment)
            }
        })

        view.findViewById<Button>(R.id.button).setOnClickListener {
            myViewModel.addUser(User("TestUser", userList.size+20))
        }
        view.findViewById<Button>(R.id.buttonLogout).setOnClickListener {
            loginViewModel.setLogged(false)
        }

    }
}