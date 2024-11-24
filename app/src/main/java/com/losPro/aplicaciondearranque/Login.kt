package com.losPro.aplicaciondearranque

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.losPro.aplicaciondearranque.dominio.data.User
import repositories.UserRepository

class Login : Fragment(){
    private lateinit var currentUser: User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireView().findViewById<TextView>(R.id.text_error_credentials)

        val button2: Button = requireView().findViewById(R.id.button_start)
        button2.setOnClickListener {
            val logged = loginUser()
            if (logged) {
                findNavController().navigate(R.id.action_fragment_login_to_fragment_home)
            }
        }
    }

    private fun loginUser(): Boolean {
        val password: String = requireView().findViewById<TextView>(R.id.editTextTextPassword).text.toString()
        val nickName: String = requireView().findViewById<TextView>(R.id.editTextTextEmailAddress).text.toString()

        val user = UserRepository.login(nickName, password)
        if (user != null) {
            this.currentUser = user
            return true
        } else {
            showErrorInLogIn()
            return false
        }
    }

    private fun showErrorInLogIn() {
        Toast.makeText(requireContext(), "Error with the credentials", Toast.LENGTH_SHORT).show()
        val errorText: TextView = requireView().findViewById(R.id.text_error_credentials)
        errorText.text = getString(R.string.password_or_email_are_incorrect)
    }
}

