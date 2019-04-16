package com.example.reqdemofisa

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tableBtn.setOnClickListener{
            val intent = Intent(this, TableActivity::class.java)
            //start Table Activity
            startActivity(intent)
            Toast.makeText(this, "Table", Toast.LENGTH_SHORT).show()
        }

        pagerBtn.setOnClickListener {
            val intent = Intent(this, PagerActivity::class.java)
            //start PagerActivity
            startActivity(intent)
            Toast.makeText(this, "Pager", Toast.LENGTH_SHORT).show()
        }

    }
}
