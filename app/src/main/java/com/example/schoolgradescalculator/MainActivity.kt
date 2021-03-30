package com.example.schoolgradescalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate.setOnClickListener {
            val grade1 = Integer.parseInt(etGrade1.text.toString())
            val grade2 = Integer.parseInt(etGrade2.text.toString())
            val absences = Integer.parseInt(etAbsences.text.toString())
            val average = (grade1 + grade2) / 2
            val resultInfoText = """
                ${getString(R.string.grades_average)}: ${average.toString()}
                ${getString(R.string.total_absences)}: ${absences.toString()}
            """.trimIndent()
            
            if (average > 6 && absences <= 10) {
                tvResult.text = getString(R.string.approved)
                tvResult.setTextColor(Color.WHITE)
            } else {
                tvResult.text = getString(R.string.reproved)
                tvResult.setTextColor(Color.RED)
            }

            tvResultInfo.text = resultInfoText
        }
    }
}