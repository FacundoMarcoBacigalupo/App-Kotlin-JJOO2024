package com.losPro.aplicaciondearranque

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.losPro.aplicaciondearranque.dominio.data.User

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    class MainViewModel : ViewModel() {
    }

    object CurrentUser {
        var currentUser : User? = null
    }

}