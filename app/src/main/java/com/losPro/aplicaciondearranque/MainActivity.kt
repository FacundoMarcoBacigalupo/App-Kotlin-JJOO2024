package com.losPro.aplicaciondearranque

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.losPro.aplicaciondearranque.dominio.data.User
import repositories.UserRepository


class MainActivity : AppCompatActivity() {
    private lateinit var currentUser: User


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity()
    }


    private fun mainActivity() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                //Do something
            }
        }
        onBackPressedDispatcher.addCallback(this, callback)


        //Set the content view to the activity_main layout & log the user
        setContentView(R.layout.activity_main)


        val button2: Button = findViewById(R.id.button_start)
        button2.setOnClickListener {
            val logged = loginUser()
            if (logged) {
                findNavController(R.id.nav_host_fragment).navigate(R.id.action_main_to_home)
            }
        }
    }


    private fun loginUser(): Boolean {
        val password: String = findViewById<TextView>(R.id.editTextTextPassword).text.toString()
        val nickName: String = findViewById<TextView>(R.id.editTextTextEmailAddress).text.toString()


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
        Toast.makeText(this, "Error with the credentials", Toast.LENGTH_SHORT).show()
        val errorText: TextView = findViewById(R.id.textView4)
        errorText.text = getString(R.string.password_or_email_are_incorrect)
    }
}