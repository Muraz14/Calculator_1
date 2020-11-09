package com.example.calculator_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    private var operand: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
        findViewById<TextView>(R.id.clearButton).setOnClickListener {
            operand = 0.0
            operation = ""
            resultTextView.text = ""
        }

        findViewById<TextView>(R.id.delBtn).setOnClickListener {
            val str = resultTextView.text.toString()
            if (!TextUtils.isEmpty(str)) {
                resultTextView.text = str.substring(0, str.length - 1)
            }
        }

    }

    fun numberClick(view: View) {
        if (view is TextView) {

            val number: String = view.text.toString()
            var result: String = resultTextView.text.toString()

            if (result == "0") {
                result = ""
            }


            resultTextView.text = result + number
        }
    }

    fun pointClick(view: View) {
        if (view is TextView) {
            val point: String = view.text.toString()
            val result: String = resultTextView.text.toString()

            if (!TextUtils.isEmpty(resultTextView.text)) {
                resultTextView.text = result + point
            }
        }
    }

    fun operationClick(view: View) {
        if (view is TextView) {
            if (!TextUtils.isEmpty(resultTextView.text)) {
                operand = resultTextView.text.toString().toDouble()
            }

            resultTextView.text = ""

            operation = view.text.toString()

        }
    }

    fun equalsClick(view: View) {
        val secOperandText: String = resultTextView.text.toString()
        var secOperand: Double = 0.0

        if (!TextUtils.isEmpty(secOperandText)) {
            secOperand = secOperandText.toDouble()
        }

        val plus: Double = operand + secOperand
        val minus: Double = operand - secOperand
        val multiply: Double = operand * secOperand
        val divide: Double = operand / secOperand


        if (operation == "+") {

            val longResultPlus = plus.toLong()
            if (plus == longResultPlus.toDouble()) {
                resultTextView.text = longResultPlus.toString()
            } else {
                resultTextView.text = plus.toString()
            }

        }


        if (operation == "-") {

            val longResultMinus = minus.toLong()
            if (minus == longResultMinus.toDouble()) {
                resultTextView.text = longResultMinus.toString()
            } else {
                resultTextView.text = minus.toString()
            }

        }


        if (operation == "*") {
            val longResultMultiply = multiply.toLong()
            if (multiply == longResultMultiply.toDouble()) {
                resultTextView.text = longResultMultiply.toString()
            } else {
                resultTextView.text = multiply.toString()
            }
        }


        if (operation == "/") {
            val longResultDivide = divide.toLong()
            if (divide == longResultDivide.toDouble()) {
                resultTextView.text = longResultDivide.toString()
            } else {
                resultTextView.text = divide.toString()
            }
        }

    }
}