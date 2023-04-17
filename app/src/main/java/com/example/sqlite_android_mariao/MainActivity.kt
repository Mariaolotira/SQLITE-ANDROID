package com.example.sqlite_android_mariao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edtname :EditText
    lateinit var edtemail : EditText
    lateinit var edtidnumber : EditText
    lateinit var btnsave :Button
    lateinit var btnview :Button
    lateinit var btndelete:Button

    lateinit var db:SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtname = findViewById(R.id.edtname)
        edtemail = findViewById(R.id.edtemail)
        edtidnumber = findViewById(R.id.edtidnumber)
        btnsave = findViewById(R.id.btnsave)
        btnview = findViewById(R.id.btnview)
        btndelete = findViewById(R.id.btndelete)

        //CREATING A DATABASE

        db = openOrCreateDatabase("MariaoDB", Context.MODE_PRIVATE, null)

        //creating a table

        db.execSQL("CREATE TABLE IF NOT EXISTS users(jina VARCHAR, arafa VARCHAR, kitambuliosho VARCHAR)")

        btnsave.setOnClickListener {
            var jinaedt = edtname.text.toString().trim()
            var arafaedt = edtemail.text.toString().trim()
            var kitambulishoedt = edtidnumber.text.toString().trim()

            //validate edit texts

            if (jinaedt.isEmpty() || kitambulishoedt.isEmpty() || arafaedt.isEmpty()){
                Toast.makeText(this, "Cannot Submit Data", Toast.LENGTH_SHORT).show()
            }else{
                //insert data
                db.execSQL("INSERT INTO users VALUES('\"+jinaedt+\"' , '\"+arafaedt+\"' , '\"+kitambulishoedt+\"')")
                Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show()

            }

            }
        }


    }

