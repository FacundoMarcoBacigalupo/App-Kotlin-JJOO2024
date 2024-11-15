package com.losPro.aplicaciondearranque

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.activity.findViewTreeOnBackPressedDispatcherOwner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.losPro.aplicaciondearranque.databinding.ActivityMainBinding
import data.Sport
import data.User
import repositories.UserRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)


        val button2 : Button = findViewById(R.id.button_start)
        button2.setOnClickListener{
            loadActivity2()
        }



       // ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
        //    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        //    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
        //    insets
        // }
    }

    fun loadActivity2() {
        val password : String = findViewById<TextView>(R.id.editTextTextPassword).text.toString()
        val nickName : String = findViewById<TextView>(R.id.editTextTextEmailAddress).text.toString()

        val user : User? = UserRepository.login(nickName, password)

        if(user != null)
            setContentView(R.layout.activity_main2)
        else{
            Toast.makeText(this, "Error, wachin", Toast.LENGTH_SHORT).show()
            val textoDeError: TextView = findViewById(R.id.textView4)
            textoDeError.text = getString(R.string.password_or_email_are_incorrect)

            val callback = object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    // Aquí defines lo que pasa al presionar "Atrás"
                    setContentView(R.layout.activity_main)
                }
            }

        }
    }

    fun loadFragmentBuyTickets(view: View) {
        setContentView(R.layout.fragment_buy_tickets)
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Aquí defines lo que pasa al presionar "Atrás"
                setContentView(R.layout.activity_main2)
            }
        }

        onBackPressedDispatcher.addCallback(this, callback)



    }


}