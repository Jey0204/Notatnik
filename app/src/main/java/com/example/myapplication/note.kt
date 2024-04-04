package com.example.myapplication

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import  android.view.View
import  android.content.Intent
import android.net.Uri
import android.widget.CheckBox
import android.widget.Toast
import android.widget.EditText
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView

class note : AppCompatActivity() {


    private lateinit var myDB: DatabaseHelper
    override fun onCreate( savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.note)

        myDB = DatabaseHelper(applicationContext)

        val back: View = findViewById(R.id.button6)
        val usun: View = findViewById(R.id.button4)
        val zapisz: View = findViewById(R.id.button5)
        val nazwaNapis: TextView = findViewById(R.id.textView10)
        val notatka: EditText = findViewById(R.id.editTextTextMultiLine2)
        val kategoriaNapis: EditText = findViewById(R.id.editTextText6)
        val gwiazda: RatingBar = findViewById(R.id.ratingBar2)


        val intent = intent
        val nazwa = intent.getStringExtra("nazwa")
        val kategoria = intent.getStringExtra("kategoria")
        val notat = intent.getStringExtra("Notatka")
        val przyp = intent.getStringExtra("Przypomnienie")
        val wazny = intent.getStringExtra("Wazna")
        val bladN:View=findViewById(R.id.editTextText6)

        nazwaNapis.text = nazwa
        kategoriaNapis.setText(kategoria)
        notatka.setText(notat)



        if (!wazny.isNullOrBlank()) {
            gwiazda.rating = wazny!!.toFloat()
        } else {
        }


        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

        usun.setOnClickListener {
            usun.setOnClickListener {
                val nazwa1 = nazwa.toString()
                myDB.usuwanie(nazwa1)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }


        zapisz.setOnClickListener {
            val nazwaDoBazy = nazwa.toString()
            val kategoriaDoBazy = kategoriaNapis.text.toString()
            val waznaDoBazy = gwiazda.rating
            val przypomniecDoBazy = przyp.toString()
            val noteNowe = notatka.text.toString()

            fun sprawdzanieSpacji(): String {
                var result = ""
                for (i in 1..10) {
                    result += " ".repeat(i)
                }
                return result
            }

            if ((kategoriaDoBazy.isEmpty() || kategoriaDoBazy == sprawdzanieSpacji()) ) {
                bladN.visibility = View.VISIBLE

            } else {
                val isInserted = myDB.updateData(
                    nazwaDoBazy,
                    kategoriaDoBazy,
                    waznaDoBazy,
                    przypomniecDoBazy,
                    noteNowe
                )

                if (isInserted) {
                    Toast.makeText(this, "Notatka została zapisana!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(
                        this,
                        "Wystąpił problem podczas zapisywania notatki.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }

        }
    }
}
