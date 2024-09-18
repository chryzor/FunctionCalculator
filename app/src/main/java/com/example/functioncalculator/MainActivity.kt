package com.example.functioncalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    lateinit var experssionView: EditText
    lateinit var resultView: EditText
    var expression = "" // For holding the user inputs
    var result = "" // For holding the result after calculation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bind UI elements
        experssionView = findViewById(R.id.zero)
        resultView = findViewById(R.id.result)


        val button0: AppCompatButton = findViewById(R.id.zero)
        val button1: AppCompatButton = findViewById(R.id.one)
        val button2: AppCompatButton = findViewById(R.id.two)
        val button3: AppCompatButton = findViewById(R.id.three)
        val button4: AppCompatButton = findViewById(R.id.four)
        val button5: AppCompatButton = findViewById(R.id.five)
        val button6: AppCompatButton = findViewById(R.id.six)
        val button7: AppCompatButton = findViewById(R.id.seven)
        val button8: AppCompatButton = findViewById(R.id.eight)
        val button9: AppCompatButton = findViewById(R.id.nine)
        val buttonPlus: AppCompatButton = findViewById(R.id.plus)
        val buttonSubtract: AppCompatButton = findViewById(R.id.subtract)
        val buttonMultiply: AppCompatButton = findViewById(R.id.multiply)
        val buttonDivide: AppCompatButton = findViewById(R.id.divide)
        val buttonEqual: AppCompatButton = findViewById(R.id.equal)
        val buttonClear: AppCompatButton = findViewById(R.id.clear)
        val buttonDecimal: AppCompatButton = findViewById(R.id.decimal)
        val buttonBackspace: AppCompatButton = findViewById(R.id.backspace)

        // Handle button clicks
        button0.setOnClickListener { appendToExpression("0") }
        button1.setOnClickListener { appendToExpression("1") }
        button2.setOnClickListener { appendToExpression("2") }
        button3.setOnClickListener { appendToExpression("3") }
        button4.setOnClickListener { appendToExpression("4") }
        button5.setOnClickListener { appendToExpression("5") }
        button6.setOnClickListener { appendToExpression("6") }
        button7.setOnClickListener { appendToExpression("7") }
        button8.setOnClickListener { appendToExpression("8") }
        button9.setOnClickListener { appendToExpression("9") }
        buttonDecimal.setOnClickListener { appendToExpression(".") }

        buttonPlus.setOnClickListener { appendToExpression("+") }
        buttonSubtract.setOnClickListener { appendToExpression("-") }
        buttonMultiply.setOnClickListener { appendToExpression("*") }
        buttonDivide.setOnClickListener { appendToExpression("/") }

        //buttonEqual.setOnClickListener { calculateResult() }
        buttonClear.setOnClickListener { clearExpression() }
       // buttonBackspace.setOnClickListener { backspace() }
    }

    private fun appendToExpression(value: String) {
        expression += value
      //  expressionView.setText(expression)
    }

    private fun clearExpression() {
        expression = ""
        result = ""
      //  expressionView.setText("0")
        resultView.setText("=0")
    }
    }

