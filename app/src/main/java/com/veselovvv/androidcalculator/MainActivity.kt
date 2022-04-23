package com.veselovvv.androidcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView
import com.veselovvv.androidcalculator.calculators.ExpressionCalculator

class MainActivity : AppCompatActivity() {
    private lateinit var expressionCalculator: ExpressionCalculator
    private lateinit var expressionEditText: TextInputEditText
    private lateinit var resultTextView: MaterialTextView
    private lateinit var clearButton: MaterialButton
    private lateinit var resultButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        expressionCalculator = (application as CalculatorApp).expressionCalculator
        expressionEditText = findViewById(R.id.expression_edit_text)
        resultTextView = findViewById(R.id.result_text_view)
        clearButton = findViewById(R.id.clear_button)
        resultButton = findViewById(R.id.result_button)

        clearButton.setOnClickListener { clearAll() }
        resultButton.setOnClickListener { showResult() }
    }

    // Обнуляет строку с выражением и результатом:
    private fun clearAll() {
        expressionEditText.setText("")
        resultTextView.text = getString(R.string.result)
    }

    // Считывает выражение и выводит результат:
    private fun showResult() {
        var expression = expressionEditText.text.toString()

        if (expression.isNotEmpty()) {
            try {
                expression = expression.replace(" ", "") // удаление пробелов
                resultTextView.text = expressionCalculator.doExpression(expression) // расчет
            } catch (e: Exception) {
                Toast.makeText(this, getString(R.string.error_message), Toast.LENGTH_LONG).show()
            }
        } else {
            expressionEditText.error = getString(R.string.fill_field_message)
        }
    }
}