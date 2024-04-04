package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var linearLayout: LinearLayout
    private lateinit var myDB: DatabaseHelper
    private lateinit var iloscTextView: TextView
    private var selectedTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myDB = DatabaseHelper(applicationContext)
        val dodaj: View = findViewById(R.id.button)
        val sortWaznosc: View = findViewById(R.id.button7)
        val sortKat: View = findViewById(R.id.button8)
        val linearLayout: LinearLayout = findViewById(R.id.layout)
        val scroll: ScrollView = findViewById(R.id.scroll)
        val ilosc: View = findViewById(R.id.textView11)
        iloscTextView = ilosc as TextView
        val wyswietlanie1: View = findViewById(R.id.button9)
        val wyswietlanie2: View = findViewById(R.id.button10)
        val wyswietlanie3: View = findViewById(R.id.button11)


        dodaj.setOnClickListener {
            val intent = Intent(this, Second::class.java)
            startActivity(intent)
        }
        wyswietlanie1.setOnClickListener{
            val cursor = myDB.SortujKat()
            if (cursor != null) {
                linearLayout.removeAllViews()
                while (cursor.moveToNext()) {
                    val columnIndex = cursor.getColumnIndex("Name")
                    val columnIndex2 = cursor.getColumnIndex("Kategoria")
                    val columnIndex3 = cursor.getColumnIndex("Wazna")

                    if (columnIndex != -1) {
                        val name1 = cursor.getString(columnIndex)
                        val name2 = cursor.getString(columnIndex2)

                        val name3 = cursor.getString(columnIndex3)



                        if(name3=="1"){
                            val name = String.format("%-5s %-5s %-5s", name1, name2, "⭐")

                            val textView = TextView(this)
                            textView.text = name
                            textView.textSize = 20f
                            textView.setTextColor(Color.BLACK)

                            val layoutParams = LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                            )
                            layoutParams.setMargins(0, 0, 0, 10)
                            textView.layoutParams = layoutParams
                            linearLayout.addView(textView)

                            textView.setOnClickListener {
                                val intent = Intent(this, note::class.java)
                                intent.putExtra("nazwa", name1)
                                intent.putExtra("kategoria", name2)
                                //intent.putExtra("Notatka",name4)
                                intent.putExtra("Wazna", name3)
                                startActivity(intent)
                            }
                        }
                    }
                       else {

                    }
                }
                cursor.close()

            }
        }
        wyswietlanie2.setOnClickListener{
            val cursor = myDB.SortujKat()
            if (cursor != null) {
                linearLayout.removeAllViews()
                while (cursor.moveToNext()) {
                    val columnIndex = cursor.getColumnIndex("Name")
                    val columnIndex2 = cursor.getColumnIndex("Kategoria")
                    val columnIndex3 = cursor.getColumnIndex("Wazna")

                    if (columnIndex != -1) {
                        val name1 = cursor.getString(columnIndex)
                        val name2 = cursor.getString(columnIndex2)

                        val name3 = cursor.getString(columnIndex3)



                        if(name3=="2"){
                            val name = String.format("%-5s %-5s %-5s", name1, name2, "⭐⭐")

                            val textView = TextView(this)
                            textView.text = name
                            textView.textSize = 20f
                            textView.setTextColor(Color.BLACK)

                            val layoutParams = LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                            )
                            layoutParams.setMargins(0, 0, 0, 10)  // Ustaw margines dolny na 20 pikseli
                            textView.layoutParams = layoutParams
                            linearLayout.addView(textView)

                            textView.setOnClickListener {
                                val intent = Intent(this, note::class.java)
                                intent.putExtra("nazwa", name1)
                                intent.putExtra("kategoria", name2)
                                //intent.putExtra("Notatka",name4)
                                intent.putExtra("Wazna", name3)
                                startActivity(intent)
                            }
                        }
                    }
                    else {

                    }
                }
                cursor.close()

            }
        }
        wyswietlanie3.setOnClickListener{
            val cursor = myDB.SortujKat()
            if (cursor != null) {
                linearLayout.removeAllViews()
                while (cursor.moveToNext()) {
                    val columnIndex = cursor.getColumnIndex("Name")
                    val columnIndex2 = cursor.getColumnIndex("Kategoria")
                    val columnIndex3 = cursor.getColumnIndex("Wazna")

                    if (columnIndex != -1) {
                        val name1 = cursor.getString(columnIndex)
                        val name2 = cursor.getString(columnIndex2)

                        val name3 = cursor.getString(columnIndex3)



                        if(name3=="3"){
                            val name = String.format("%-5s %-5s %-5s", name1, name2, "⭐⭐⭐")

                            val textView = TextView(this)
                            textView.text = name
                            textView.textSize = 20f
                            textView.setTextColor(Color.BLACK)

                            val layoutParams = LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                            )
                            layoutParams.setMargins(0, 0, 0, 10)  // Ustaw margines dolny na 20 pikseli
                            textView.layoutParams = layoutParams
                            linearLayout.addView(textView)

                            textView.setOnClickListener {
                                val intent = Intent(this, note::class.java)
                                intent.putExtra("nazwa", name1)
                                intent.putExtra("kategoria", name2)
                                //intent.putExtra("Notatka",name4)
                                intent.putExtra("Wazna", name3)
                                startActivity(intent)
                            }
                        }
                    }
                    else {

                    }
                }
                cursor.close()

            }
        }

        sortKat.setOnClickListener {
            val cursor = myDB.SortujKat()
            if (cursor != null) {
                linearLayout.removeAllViews()
                while (cursor.moveToNext()) {
                    val columnIndex = cursor.getColumnIndex("Name")
                    val columnIndex2 = cursor.getColumnIndex("Kategoria")
                    val columnIndex3 = cursor.getColumnIndex("Wazna")

                    if (columnIndex != -1) {
                        val name1 = cursor.getString(columnIndex)
                        val name2 = cursor.getString(columnIndex2)

                        val name3 = cursor.getString(columnIndex3)

                        var znak = ""
                        if (name3 == "3") {
                            znak = "⭐⭐⭐"

                        } else if (name3 == "2") {
                            znak = "⭐⭐"
                        } else if (name3 == "1") {
                            znak = "⭐"
                        }


                        val name = String.format("%-5s %-5s %-5s", name1, name2, znak)

                        val textView = TextView(this)
                        textView.text = name
                        textView.textSize = 20f
                        textView.setTextColor(Color.BLACK)

                        val layoutParams = LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                        )
                        layoutParams.setMargins(0, 0, 0, 10)  // Ustaw margines dolny na 20 pikseli
                        textView.layoutParams = layoutParams
                        linearLayout.addView(textView)

                        textView.setOnClickListener {
                            val intent = Intent(this, note::class.java)
                            intent.putExtra("nazwa", name1)
                            intent.putExtra("kategoria", name2)
                            //intent.putExtra("Notatka",name4)
                            intent.putExtra("Wazna", name3)
                            startActivity(intent)
                        }
                    } else {

                    }
                }
                cursor.close()

            }
        }

        sortWaznosc.setOnClickListener {
            val cursor = myDB.SortujWaznosc()
            if (cursor != null) {
                linearLayout.removeAllViews()
                while (cursor.moveToNext()) {

                    val columnIndex = cursor.getColumnIndex("Name")
                    val columnIndex2 = cursor.getColumnIndex("Kategoria")
                    val columnIndex3 = cursor.getColumnIndex("Wazna")

                    if (columnIndex != -1) {
                        val name1 = cursor.getString(columnIndex)
                        val name2 = cursor.getString(columnIndex2)

                        val name3 = cursor.getString(columnIndex3)

                        var znak = ""
                        if (name3 == "3") {
                            znak = "⭐⭐⭐"

                        } else if (name3 == "2") {
                            znak = "⭐⭐"
                        } else if (name3 == "1") {
                            znak = "⭐"
                        }


                        val name = String.format("%-5s %-5s %-5s", name1, name2, znak)

                        val textView = TextView(this)
                        textView.text = name
                        textView.textSize = 20f
                        textView.setTextColor(Color.BLACK)

                        val layoutParams = LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                        )
                        layoutParams.setMargins(0, 0, 0, 10)  // Ustaw margines dolny na 20 pikseli
                        textView.layoutParams = layoutParams
                        linearLayout.addView(textView)

                        textView.setOnClickListener {
                            val intent = Intent(this, note::class.java)
                            intent.putExtra("nazwa", name1)
                            intent.putExtra("kategoria", name2)
                            //intent.putExtra("Notatka",name4)
                            intent.putExtra("Wazna", name3)
                            startActivity(intent)
                        }
                    } else {

                    }

                }
                cursor.close()
            }
        }

        fun wyswietlania() {
            var ilosc=0
            val cursor = myDB.Wyswietl()
            if (cursor != null) {
                while (cursor.moveToNext()) {

                    val columnIndex = cursor.getColumnIndex("Name")
                    val columnIndex2 = cursor.getColumnIndex("Kategoria")
                    val columnIndex3 = cursor.getColumnIndex("Wazna")
                    val columnIndex4 = cursor.getColumnIndex("Notatka")
                    val columnIndex5 = cursor.getColumnIndex("Przypomnienie")

                    if (columnIndex != -1) {
                        val name1 = cursor.getString(columnIndex)
                        val name2 = cursor.getString(columnIndex2)
                        val name3 = cursor.getString(columnIndex3)
                        val name4 = cursor.getString(columnIndex4)
                        //val name5 = cursor.getColumnName(columnIndex5)
                        var znak = ""
                        if (name3 == "3") {
                            znak = "⭐⭐⭐"
                            ilosc++

                        } else if (name3 == "2") {
                            znak = "⭐⭐"
                        } else if (name3 == "1") {
                            znak = "⭐"
                        }


                        val name = String.format("%-5s %-5s %-5s", name1, name2, znak)

                        val textView = TextView(this)
                        textView.text = name
                        textView.textSize = 20f
                        textView.setTextColor(Color.BLACK)

                        val layoutParams = LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                        )
                        layoutParams.setMargins(0, 0, 0, 10)  // Ustaw margines dolny na 20 pikseli
                        textView.layoutParams = layoutParams
                        linearLayout.addView(textView)

                        textView.setOnClickListener {
                            val intent = Intent(this, note::class.java)
                            intent.putExtra("nazwa", name1)
                            intent.putExtra("kategoria", name2)
                            intent.putExtra("Notatka", name4)
                            intent.putExtra("Wazna", name3)
                            startActivity(intent)
                        }
                    } else {

                    }
                }
                cursor.close()
                iloscTextView.text = "Ilość bardzo ważnych notatek: $ilosc"
            }

        }
        wyswietlania()
    }

}

