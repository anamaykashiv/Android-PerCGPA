package com.example.percentage

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var etObtainedMarks: EditText
    private lateinit var etTotalMarks: EditText
    private lateinit var btnCalculatePercentage: Button
    private lateinit var tvResult: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etObtainedMarks = findViewById(R.id.etObtainedMarks)
        etTotalMarks = findViewById(R.id.etTotalMarks)
        btnCalculatePercentage = findViewById(R.id.btnCalculatePercentage)
        tvResult = findViewById(R.id.tvResult)

        btnCalculatePercentage.setOnClickListener(View.OnClickListener {
            val obtainedMarks = etObtainedMarks.text.toString().toFloatOrNull() ?: 0f
            val totalMarks = etTotalMarks.text.toString().toFloatOrNull() ?: 0f

            if (totalMarks != 0f) {
                val percentage = (obtainedMarks / totalMarks) * 100
                val cgpa = percentage / 9.5
                tvResult.text = "Percentage: ${String.format("%.2f", percentage)}%\nCGPA: ${String.format("%.2f", cgpa)}"
            } else {
                tvResult.text = "Total marks cannot be zero."
            }
        })
    }
}
