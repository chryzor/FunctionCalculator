package com.example.functioncalculator

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    var expression = "" // For holding the user inputs
    var result = "" // For holding the result after calculation
    var lastResult = 0

    lateinit var expressionView: EditText
    lateinit var resultView: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        expressionView = findViewById(R.id.expression)
        resultView = findViewById(R.id.result)

        val exitButton: AppCompatButton = findViewById(R.id.exit)
        exitButton.setOnClickListener() {
            finish()
        }

        val last: AppCompatButton = findViewById(R.id.last)
        last.setOnClickListener {
            resultView.setText(lastResult.toString())
        }

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
//
        buttonPlus.setOnClickListener {
            appendToExpression("+")
        }
        buttonSubtract.setOnClickListener {
            appendToExpression("-")
        }
        buttonMultiply.setOnClickListener {
            appendToExpression("*")
        }
        buttonDivide.setOnClickListener {
            appendToExpression("/")
        }

        buttonEqual.setOnClickListener { calculateResult(expression) }
        buttonClear.setOnClickListener { clearExpression() }
        buttonBackspace.setOnClickListener { backspace() }
    }


    private fun appendToExpression(value: String) {
        expression += value
        expressionView.setText(expression)
    }

    private fun calculateResult(expression : String) {
        var ans = 0
        var fnum = 0
        var snum = 0
        var curr = 0

        for (ch in expression) {
            if (ch == '+') {
                fnum = expression.substring(0, curr).toInt()
                snum = expression.substring(curr + 1).toInt()
                ans = fnum + snum
                break
            } else if (ch == '-') {
                fnum = expression.substring(0, curr).toInt()
                snum = expression.substring(curr + 1).toInt()
                ans = fnum - snum
                break
            } else if (ch == '*') {
                fnum = expression.substring(0, curr).toInt()
                snum = expression.substring(curr + 1).toInt()
                ans = fnum * snum
                break
            } else if (ch == '/') {
                fnum = expression.substring(0, curr).toInt()
                snum = expression.substring(curr + 1).toInt()
                ans = fnum / snum
                break
            }
            curr += 1
        }
        resultView.setText(ans.toString())
        lastResult = ans
    }

    private fun backspace() {
        if (expression.isNotEmpty()) {
            expression = expression.dropLast(1)
            expressionView.setText(expression)
        }
    }

    private fun clearExpression() {
        expression = ""
        result = ""
        expressionView.setText("0")
        resultView.setText("=0")
    }
}

