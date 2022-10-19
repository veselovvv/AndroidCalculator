package com.veselovvv.androidcalculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView
import com.veselovvv.androidcalculator.calculators.ExpressionCalculator

class MainActivity : AppCompatActivity() {
    private lateinit var expressionCalculator: ExpressionCalculator
    private lateinit var expressionEditText: TextInputEditText
    private lateinit var resultTextView: MaterialTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        expressionCalculator = (application as CalculatorApp).expressionCalculator
        expressionEditText = findViewById(R.id.expression_edit_text)
        resultTextView = findViewById(R.id.result_text_view)

        findViewById<MaterialButton>(R.id.clear_button).setOnClickListener {
            // Обнуляет строку с выражением и результатом:
            expressionEditText.setText("")
            resultTextView.text = getString(R.string.result)
        }

        findViewById<MaterialButton>(R.id.result_button).setOnClickListener {
            // Считывает выражение и выводит результат:
            var expression = expressionEditText.text.toString()

            if (expression.isNotEmpty()) {
                try {
                    expression = expression.replace(" ", "") // удаление пробелов
                    resultTextView.text = expressionCalculator.doExpression(expression) // расчет
                } catch (e: Exception) {
                    Toast.makeText(this, getString(R.string.error_message), Toast.LENGTH_LONG).show()
                }
            } else expressionEditText.error = getString(R.string.fill_field_message)
        }
    }
}