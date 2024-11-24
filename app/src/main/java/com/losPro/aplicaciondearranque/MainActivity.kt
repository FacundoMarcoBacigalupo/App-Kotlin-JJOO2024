package com.losPro.aplicaciondearranque

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavDeepLinkBuilder
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
                // Navigate using deep link
                val pendingIntent = NavDeepLinkBuilder(this)
                    .setGraph(R.navigation.nav_graph)
                    .setDestination(R.id.activity_home)
                    .createPendingIntent()

                pendingIntent.send()
            }
        }
    }


    private fun loginUser(): Boolean {
        val password: String = findViewById<TextView>(R.id.editTextTextPassword).text.toString()
        val nickName: String = findViewById<TextView>(R.id.editTextTextEmailAddress).text.toString()


        val user = UserRepository.login(nickName, password)
        if (user != null) {
            this.currentUser = user

            // Navigate using deep link
            val pendingIntent = NavDeepLinkBuilder(this)
                .setGraph(R.navigation.nav_graph)
                .setDestination(R.id.activity_home)
                .createPendingIntent()

            pendingIntent.send()

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