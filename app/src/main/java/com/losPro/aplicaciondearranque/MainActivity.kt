package com.losPro.aplicaciondearranque

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.losPro.aplicaciondearranque.dominio.data.User
import repositories.UserRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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



    fun loadMainActivity(view: View) {
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "Session closed", Toast.LENGTH_SHORT).show()
    }



    fun loadActivity2() {
        val password : String = findViewById<TextView>(R.id.editTextTextPassword).text.toString()
        val nickName : String = findViewById<TextView>(R.id.editTextTextEmailAddress).text.toString()

        val user : User? = UserRepository.login(nickName, password)

        if (user != null)
            setContentView(R.layout.activity_main2)
        else {
            Toast.makeText(this, "Error with the credentials", Toast.LENGTH_SHORT).show()
            val errorText: TextView = findViewById(R.id.textView4)
            errorText.text = getString(R.string.password_or_email_are_incorrect)

            val callback = object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    setContentView(R.layout.activity_main) //Back to activity_main
                }
            }
        }
    }



    fun loadFragmentBuyTickets(view: View) {
        setContentView(R.layout.fragment_buy_tickets)
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                setContentView(R.layout.activity_main2) //Back to activity_main2
            }
        }

        onBackPressedDispatcher.addCallback(this, callback)
    }




    fun loadFragmentViewMedals(view: View) {
        setContentView(R.layout.fragment_view_medals)

    }



    fun loadFragmentPurchaseHistory(view: View){
        setContentView(R.layout.fragment_purchase_history)

    }
}