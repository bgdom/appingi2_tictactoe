package com.epita.dom.tictactoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.btn_start)
        val edit = findViewById<EditText>(R.id.edit_name)

        btn.setOnClickListener {
            val txt = edit.text.toString().trim()
            if(txt.isEmpty())
                return@setOnClickListener

            val intent = Intent(this@HomeActivity, GameActivity::class.java)
            intent.putExtra("name", txt)
            startActivity(intent)
        }
    }
}
