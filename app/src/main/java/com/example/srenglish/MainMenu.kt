package com.example.srenglish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val buttonClick = findViewById<Button>(R.id.buttonmain2)
        buttonClick.setOnClickListener {
            val intent = Intent(this, PlayGround::class.java)
            startActivity(intent)
        }

        val button2Click = findViewById<Button>(R.id.buttonmain1)
        button2Click.setOnClickListener {
            val intent2 = Intent(this, SecondActivity::class.java)
            startActivity(intent2)
        }

        val button3Click = findViewById<Button>(R.id.button7)
        button3Click.setOnClickListener {
            val intent3 = Intent(this, MainActivity::class.java)
            startActivity(intent3)
        }

        val button4Click = findViewById<Button>(R.id.button10)
        button4Click.setOnClickListener {
            val intent4 = Intent(this, Login::class.java)
            startActivity(intent4)
        }
    }
}