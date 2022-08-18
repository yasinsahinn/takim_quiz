package com.example.teamknowledgeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sonuc.*

class SonucActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonuc)

        val dogruSayac = intent.getIntExtra("dogruSayac",0)

        textViewSonuc.text = "$dogruSayac DOĞRU  ${7-dogruSayac} YANLIŞ"
        textViewYuzdeSonuc.text = "%${(dogruSayac*100/7)} Başarı Oranı"

        buttonTekrar.setOnClickListener {
            val intent = Intent(applicationContext,QuizActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}