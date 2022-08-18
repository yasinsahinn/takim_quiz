package com.example.teamknowledgeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veritabaniKopyala()

        buttonBasla.setOnClickListener {
            val intent = Intent(applicationContext,QuizActivity::class.java)
            startActivity(intent)
        }

    }

    fun veritabaniKopyala()
    {
        val copyHelper = DatabaseCopyHelper(this@MainActivity)

        try
        {
            copyHelper.createDataBase()
            copyHelper.openDataBase()
        }
        catch (e:Exception)
        {
            e.printStackTrace()
        }
    }

}