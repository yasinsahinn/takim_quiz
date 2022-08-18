package com.example.teamknowledgeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    private lateinit var sorular : ArrayList<Takimlar>
    private lateinit var yanlisSecenekler:ArrayList<Takimlar>
    private lateinit var dogruSoru:Takimlar
    private lateinit var tumSecenekler : HashSet<Takimlar>
    private lateinit var vt:VeritabaniYardimcisi

    private var soruSayac = 0
    private var dogruSayac = 0
    private var yanlisSayac = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        vt = VeritabaniYardimcisi(this@QuizActivity)

        sorular = Takimlardao().rasgeleYediLogoGetir(vt)

        soruYukle()


        buttonA.setOnClickListener {
            dogruKontrol(buttonA)
            soruSayacKontrol()
        }
        buttonB.setOnClickListener {
            dogruKontrol(buttonB)
            soruSayacKontrol()
        }
        buttonC.setOnClickListener {
            dogruKontrol(buttonC)
            soruSayacKontrol()
        }
        buttonD.setOnClickListener {
            dogruKontrol(buttonD)
            soruSayacKontrol()
        }
    }

    fun soruYukle()
    {
        textViewSoruSayi.text = ("${soruSayac+1}. Soru")

        dogruSoru = sorular.get(soruSayac)

        imageViewTeam.setImageResource(resources.getIdentifier(dogruSoru.takim_resim,"drawable",packageName))

        yanlisSecenekler = Takimlardao().rasgeleUcSecenekGetir(vt,dogruSoru.takim_id)

        tumSecenekler = HashSet()
        tumSecenekler.add(dogruSoru)
        tumSecenekler.add(yanlisSecenekler.get(0))
        tumSecenekler.add(yanlisSecenekler.get(1))
        tumSecenekler.add(yanlisSecenekler.get(2))

        buttonA.text = tumSecenekler.elementAt(0).takim_ad
        buttonB.text = tumSecenekler.elementAt(1).takim_ad
        buttonC.text = tumSecenekler.elementAt(2).takim_ad
        buttonD.text = tumSecenekler.elementAt(3).takim_ad
    }

    fun soruSayacKontrol()
    {
        soruSayac++

        if (soruSayac!=7)
        {
           soruYukle()
        }
        else
        {
            val intent = Intent(applicationContext,SonucActivity::class.java)
            intent.putExtra("dogruSayac",dogruSayac)
            startActivity(intent)
            finish()
        }
    }

    fun dogruKontrol(button: Button)
    {
        val buttonYazi = button.text.toString()
        val dogruCevap = dogruSoru.takim_ad

        if (buttonYazi == dogruCevap)
        {
            dogruSayac++
        }
        else
        {
            yanlisSayac++
        }

        textViewDogru.text = "Doğru Sayısı : $dogruSayac"
        textViewYanlis.text = "Yanlış Sayısı : $yanlisSayac"

    }
}