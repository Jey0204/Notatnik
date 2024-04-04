package com.example.myapplication

import android.app.AlarmManager
import android.app.DatePickerDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import java.util.Calendar


class Second : AppCompatActivity(){
    private lateinit var myDB: DatabaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add)

        myDB = DatabaseHelper(applicationContext)

        val buttonMain:View = findViewById(R.id.button3)
        val dodaj:View = findViewById(R.id.button2)
        val nazwaEditText: EditText = findViewById(R.id.editTextText)
        val kategoriaEditText: EditText = findViewById(R.id.editTextText2)
        val bladN: View = findViewById(R.id.textView4)
        val bladK:View = findViewById(R.id.textView5)
        val bladP:View = findViewById(R.id.textView6)
        val notatka : EditText = findViewById(R.id.editTextTextMultiLine)
        val gwiazdki : RatingBar = findViewById(R.id.ratingBar)


        buttonMain.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


        dodaj.setOnClickListener{

            val nazwa = nazwaEditText.text.toString()
            val kategoria = kategoriaEditText.text.toString()
            val gwiazdka = gwiazdki.rating
            val przypomniec = "1"
            val note = notatka.text.toString()
            val zdjecie = ByteArray(1000)
            bladN.visibility=View.INVISIBLE
            bladK.visibility=View.INVISIBLE
            bladP.visibility=View.INVISIBLE

            fun sprawdzanieSpacji(): String {
                var result = ""
                for (i in 1..10) {
                    result += " ".repeat(i)
                }
                return result
            }
            val userName = nazwaEditText.text.toString().trim()
            val userKat = kategoriaEditText.text.toString().trim()

            if((userName.isEmpty() || userName  == sprawdzanieSpacji() )&&( userKat.isEmpty() || userKat==sprawdzanieSpacji())){
                bladN.visibility = View.VISIBLE
                bladK.visibility = View.VISIBLE

            }
            else if(userName.isEmpty() || userName  == sprawdzanieSpacji()){
                bladN.visibility = View.VISIBLE
            }
            else if(myDB.nazwaAlreadyExists(userName)){
                bladP.visibility = View.VISIBLE
            }

            else if(userKat.isEmpty() || userKat==sprawdzanieSpacji()){
                bladK.visibility = View.VISIBLE
            }

            else{

                val isInserted = myDB.insertData(nazwa, kategoria, gwiazdka, przypomniec, note)
                if (isInserted) {
                    Toast.makeText(this, "Notatka została zapisana!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Wystąpił problem podczas zapisywania notatki.", Toast.LENGTH_SHORT).show()
                }}
        }
    }

}