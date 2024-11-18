package com.losPro.aplicaciondearranque

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.losPro.aplicaciondearranque.dominio.data.EventAdapter
import com.losPro.aplicaciondearranque.dominio.data.User
import repositories.EventRepository
import repositories.UserRepository

class MainActivity : AppCompatActivity() {
    private lateinit var currentUser : User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity()
    }


    private fun mainActivity() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {

            }
        }

        onBackPressedDispatcher.addCallback(this, callback)

        //Set the content view to the activity_main layout & log the user
        setContentView(R.layout.activity_main)

        val button2 : Button = findViewById(R.id.button_start)
        button2.setOnClickListener{
            val logged = loginUser()
            if (logged)
                loadActivityMain2()
        }
    }


    private fun loginUser() : Boolean  {
        val password : String = findViewById<TextView>(R.id.editTextTextPassword).text.toString()
        val nickName : String = findViewById<TextView>(R.id.editTextTextEmailAddress).text.toString()

        val user = UserRepository.login(nickName, password)
        if (user != null){
            this.currentUser = user
            return true
        }
        else
        {
            showErrorInLogIn()
            return false
        }
    }


    //Redirect to Home
    private fun loadActivityMain2() {
        setContentView(R.layout.activity_main2)


        val buttonExit : Button = findViewById(R.id.button_go_from_main2_to_main)
        buttonExit.setOnClickListener{mainActivity()}
    }


    //Redirect to Buy Tickets
    fun loadFragmentBuyTickets(view: View) {
        setContentView(R.layout.fragment_buy_tickets)

        val recyclerViewEvents = findViewById<RecyclerView>(R.id.recyclerViewEvents)
        recyclerViewEvents.layoutManager = LinearLayoutManager(this)
            recyclerViewEvents.adapter = EventAdapter(EventRepository.getEvents())


        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
               //Back to activity_main2
                loadActivityMain2()
            }
        }
        onBackPressedDispatcher.addCallback(this, callback)

    }


    //Redirect to View All Medals
    fun loadFragmentViewMedals(view: View) {
        setContentView(R.layout.fragment_view_medals)
    }


    //Redirect to Purchase History
    fun loadFragmentPurchaseHistory(view: View){
        setContentView(R.layout.fragment_purchase_history)
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // setContentView(R.layout.activity_main) //Back to activity_main
                mainActivity()
            }

        }
    }


    private fun showErrorInLogIn() {
        Toast.makeText(this, "Error with the credentials", Toast.LENGTH_SHORT).show()
        val errorText: TextView = findViewById(R.id.textView4)
        errorText.text = getString(R.string.name_or_password_incorrect)
    }

}