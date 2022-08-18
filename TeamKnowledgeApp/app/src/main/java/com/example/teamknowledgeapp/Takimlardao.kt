package com.example.teamknowledgeapp

class Takimlardao
{
    fun rasgeleYediLogoGetir(vt:VeritabaniYardimcisi) : ArrayList<Takimlar>
    {
        val takimlarList = ArrayList<Takimlar>()
        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM takimlar ORDER BY RANDOM() LIMIT 7",null)

        while (cursor.moveToNext())
        {
            val takim = Takimlar(cursor.getInt(cursor.getColumnIndex("takim_id"))
                ,cursor.getString(cursor.getColumnIndex("takim_ad"))
                ,cursor.getString(cursor.getColumnIndex("takim_resim")))

            takimlarList.add(takim)
        }
        return takimlarList
    }

    fun rasgeleUcSecenekGetir(vt:VeritabaniYardimcisi,takim_id:Int) : ArrayList<Takimlar>
    {
        val takimlarList = ArrayList<Takimlar>()
        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM takimlar WHERE takim_id != $takim_id ORDER BY RANDOM() LIMIT 3",null)

        while (cursor.moveToNext())
        {
            val takim = Takimlar(cursor.getInt(cursor.getColumnIndex("takim_id"))
                ,cursor.getString(cursor.getColumnIndex("takim_ad"))
                ,cursor.getString(cursor.getColumnIndex("takim_resim")))

            takimlarList.add(takim)
        }
        return takimlarList
    }
}