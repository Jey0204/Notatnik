package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DatabaseHelper(context: Context?) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    companion object {
        private const val DATABASE_NAME = "Notes"
        private const val TABLE_NAME = "Tabela"
        private const val COL_1 = "id"
        private const val COL_2 = "Name"
        private const val COL_3 = "Kategoria"
        private const val COL_4 = "Wazna"
        private const val COL_5 = "Przypomnienie"
        private const val COL_6 = "Notatka"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE IF NOT EXISTS $TABLE_NAME (ID INTEGER PRIMARY KEY AUTOINCREMENT, $COL_2 TEXT, $COL_3 TEXT, $COL_4 TEXT, $COL_5 DATA, $COL_6 TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertData(name: String, kategoria: String, wazna: Float, przypomnienie: String, note: String): Boolean {
        val dp = this.writableDatabase
        val values = ContentValues()
        values.put(COL_2, name)
        values.put(COL_3, kategoria)
        values.put(COL_4, wazna)
        values.put(COL_5, przypomnienie)
        values.put(COL_6, note)

        val result = dp.insert(TABLE_NAME, null, values)
        return result != -1L
    }


    fun Wyswietl(): Cursor? {
        val dp = this.readableDatabase
        var cursor: Cursor? = null
        val columns = arrayOf(COL_2,COL_3, COL_4, COL_6)
        cursor = dp.query("Tabela", columns, null, null, null, null, null)
        return cursor
    }

    fun SortujWaznosc(): Cursor? {
        val db = this.readableDatabase
        var cursor: Cursor? = null
        val columns = arrayOf(COL_2, COL_3, COL_4)
        cursor = db.query("Tabela", columns, null, null, null, null, "$COL_4 DESC")

        return cursor
    }

    fun SortujKat(): Cursor? {
        val db = this.readableDatabase
        var cursor: Cursor? = null
        val columns = arrayOf(COL_2, COL_3, COL_4)
        cursor = db.query("Tabela", columns, null, null, null, null, "$COL_3 COLLATE NOCASE ASC")

        return cursor
    }
    fun usuwanie(name: String){
        val db = this.writableDatabase
        val whereClause = "Name = ?"
        val whereArgs = arrayOf(name)

        db.delete("Tabela", whereClause, whereArgs)
        db.close()
    }
    fun updateData(nazwa: String, kategoria: String, wazna: Float, przypomnienie: String, notatka: String): Boolean {
        val dp = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_3, kategoria)
        contentValues.put(COL_4, wazna)
        contentValues.put(COL_5, przypomnienie)
        contentValues.put(COL_6, notatka)

        val whereClause = "Name = ?"
        val whereArgs = arrayOf(nazwa)

        val result = dp.update("Tabela", contentValues, whereClause, whereArgs)
        dp.close()

        return result != -1
    }
    fun nazwaAlreadyExists(nazwa: String): Boolean {
        val dp = this.readableDatabase
        val query = "SELECT * FROM Tabela WHERE Name = ?"
        val cursor = dp.rawQuery(query, arrayOf(nazwa))
        val result = cursor.count > 0
        cursor.close()
        dp.close()
        return result
    }

    fun PokazNotatkiZWaznoscia(waznosc: String): Cursor? {
        val db = this.readableDatabase
        val query = "SELECT * FROM YourTableName WHERE Wazna = ?"
        return db.rawQuery(query, arrayOf(waznosc))
    }

}
