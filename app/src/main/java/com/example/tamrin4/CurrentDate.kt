package com.example.tamrin4
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class CurrentDate : AppCompatActivity() {

    private lateinit var dateEditText: EditText
    private lateinit var dateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current_date)

        dateEditText = findViewById(R.id.dateEditText)
        dateButton = findViewById(R.id.dateButton)
        dateButton.setOnClickListener { showDatePicker() }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            val selectedDate = "$selectedYear/${selectedMonth + 1}/$selectedDay"
            dateEditText.setText(selectedDate)
        }, year, month, day)

        datePickerDialog.show()
    }
}
