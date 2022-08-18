package com.example.teamknowledgeapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class VeritabaniYardimcisi(context: Context) : SQLiteOpenHelper(context,"takimquiz.sqlite",null,1)
{
    override fun onCreate(db: SQLiteDatabase?)
    {
        db?.execSQL("CREATE TABLE IF NOT EXISTS \"takimlar\" (\n" +
                "\t\"takim_id\"\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"takim_ad\"\tTEXT,\n" +
                "\t\"takim_resim\"\tTEXT\n" +
                ");")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int)
    {
        db?.execSQL("DROP TABLE IF EXISTS takimlar")

        onCreate(db)
    }

}