package com.example.tamrin4

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.yamin8000.ppn.PersianDigits


class PersianNum : AppCompatActivity() {

    private lateinit var inputtext: EditText
    private lateinit var convertbutton: Button
    private lateinit var resulttext: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persian_num)

        inputtext = findViewById(R.id.inputtext)
        convertbutton = findViewById(R.id.convertbutton)
        resulttext = findViewById(R.id.resulttext)

        convertbutton.setOnClickListener { // اصلاح شده: setOnClickListener
            val numberstring = inputtext.text.toString()
            if (numberstring.isNotEmpty()) {
                try {
                    val result: String = PersianDigits.spellToPersian(numberstring)
                    resulttext.text = result
                } catch (e: NumberFormatException) {
                    resulttext.text = "عدد نامعتبر"
                }
            } else {
                resulttext.text = "عدد را وارد کنید"
            }
        }
    }
}