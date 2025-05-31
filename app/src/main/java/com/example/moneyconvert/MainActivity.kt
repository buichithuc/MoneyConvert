package com.example.moneyconvert

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var result : TextView
    lateinit var spinner1 : Spinner
    lateinit var spinner2 : Spinner
    lateinit var input : EditText
    lateinit var convert : Button
    var n1 = "American - USD"
    var n2 = "American - USD"
    private val exchangeRate = mapOf(
        "American - USD" to 1.0,
        "VietNam - Dong" to 25000.0,
        "Korea - Won" to 1467.0,
        "Japan - Yen" to 150.06,
        "India - Rupee" to 85.56

// hello commit
    )
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val nations : Array<String> = arrayOf("American - USD", "VietNam - Dong", "Korea - Won", "Japan - Yen", "India - Rupee")
        val arrayAdapter : ArrayAdapter<String> = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            nations
        )

        spinner1 = findViewById(R.id.sp1)
        spinner1.adapter = arrayAdapter
        spinner1.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                n1 = nations[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        spinner2 = findViewById(R.id.sp2)
        spinner2.adapter = arrayAdapter
        spinner2.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                n2 = nations[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        convert = findViewById(R.id.button)
        convert.setOnClickListener {
            var amount = input.text.toString().toDoubleOrNull() ?: 0.0
            var source = exchangeRate[n2] ?: 1.0
            var des = exchangeRate[n1] ?: 1.0
            var res = (amount/source) * des
            result.text = res.toString()
        }






    }
}