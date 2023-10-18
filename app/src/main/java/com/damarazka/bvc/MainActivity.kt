package com.damarazka.bvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtWidth: EditText
    private lateinit var edtLength: EditText
    private lateinit var edtHeight: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtWidth = findViewById(R.id.edt_width)
        edtLength = findViewById(R.id.edt_length)
        edtHeight = findViewById(R.id.edt_Height)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)
        btnCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_calculate) {
            val inputWidth = edtWidth.text.toString().trim()
            val inputLength = edtLength.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()
            var isEmptyField = false

            if (inputWidth.isEmpty()) {
                isEmptyField = true
                edtWidth.error = "This field must be fill"
            }

            if (inputLength.isEmpty()) {
                isEmptyField = true
                edtLength.error = "This field must be fill"
            }

            if (inputHeight.isEmpty()) {
                isEmptyField = true
                edtHeight.error = "This field must be fill"
            }
            if (!isEmptyField) {
                val volume = inputWidth.toDouble() * inputLength.toDouble() * inputHeight.toDouble()
                tvResult.text = volume.toString()
            }
        }
    }
}