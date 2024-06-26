package com.example.spdemo

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var nameText:EditText
    private lateinit var ageText:EditText
    private lateinit var sf:SharedPreferences
    private lateinit var editor:SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        nameText = findViewById(R.id.etName)
        ageText = findViewById(R.id.etAge)
        sf = getSharedPreferences("my-sf", MODE_PRIVATE)
        editor = sf.edit()

    }

    override fun onPause() {
        super.onPause()
        val name = nameText.text.toString()
        val age = ageText.text.toString().toInt()

        editor.apply() {
            putString("my_name", name)
            putInt("my_age", age)
            commit()
        }


    }
        override fun onResume() {
            super.onResume()
            val name = sf.getString("sf_name", null)
            val age = sf.getInt("sf_age", 0)
            nameText.setText(name)
            if (age != 0) {
                ageText.setText(age.toString())
            }

        }

    }