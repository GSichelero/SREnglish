package com.example.srenglish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CreateAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        val buttonClick = findViewById<Button>(R.id.button5)
        buttonClick.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        val button2Click = findViewById<Button>(R.id.button6)
        button2Click.setOnClickListener {
            val intent2 = Intent(this, MainMenu::class.java)
            startActivity(intent2)
        }
    }
}