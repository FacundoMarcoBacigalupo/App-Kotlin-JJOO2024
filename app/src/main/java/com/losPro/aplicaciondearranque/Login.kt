package com.losPro.aplicaciondearranque

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import repositories.UserRepository

class Login : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                //Exit from application
                android.os.Process.killProcess(android.os.Process.myPid())
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)

        val button2: Button = requireView().findViewById(R.id.button_start)
        button2.setOnClickListener {
            val logged = loginUser()
            if (logged) {
                Toast.makeText(requireContext(), "Login successful ${MainActivity.CurrentUser.currentUser?.name}" , Toast.LENGTH_SHORT).show()
                val data = "data"
                val bundle = bundleOf("data" to data)
                findNavController().navigate(R.id.action_fragment_login_to_fragment_home, bundle)
            }
        }
    }

    private fun loginUser(): Boolean {
        val password: String = requireView().findViewById<TextView>(R.id.editTextTextPassword).text.toString()
        val nickName: String = requireView().findViewById<TextView>(R.id.editTextTextEmailAddress).text.toString()

        val user = UserRepository.login(nickName, password)
        if (user != null) {
            MainActivity.CurrentUser.currentUser = user
            return true
        } else {
           showErrorInLogIn()
            return false
        }
    }

   private fun showErrorInLogIn() {
        Toast.makeText(requireContext(), "Error with the credentials", Toast.LENGTH_SHORT).show()
    }

}

