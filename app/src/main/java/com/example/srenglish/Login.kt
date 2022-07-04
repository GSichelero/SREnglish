package com.example.srenglish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonClick = findViewById<Button>(R.id.button3)
        buttonClick.setOnClickListener {
            val intent = Intent(this, CreateAccount::class.java)
            startActivity(intent)
        }

        val button2Click = findViewById<Button>(R.id.button2)
        button2Click.setOnClickListener {
            val intent2 = Intent(this, MainMenu::class.java)
            startActivity(intent2)
        }
    }
}