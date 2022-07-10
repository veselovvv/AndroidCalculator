package com.veselovvv.androidcalculator

import android.app.Application
import com.veselovvv.androidcalculator.calculators.Calculator
import com.veselovvv.androidcalculator.calculators.ExpressionCalculator
import com.veselovvv.androidcalculator.parsers.OperandIndexFromExpressionArrayParser
import com.veselovvv.androidcalculator.parsers.OperandsParser
import com.veselovvv.androidcalculator.parsers.UnaryMinusParser
import com.veselovvv.androidcalculator.parsers.VariablesArrayParser

class CalculatorApp : Application() {
    lateinit var expressionCalculator: ExpressionCalculator
    private lateinit var intItemArrayRemover: ItemArrayRemover<Int>
    private lateinit var stringItemArrayRemover: ItemArrayRemover<String>

    override fun onCreate() {
        super.onCreate()
        intItemArrayRemover = ItemArrayRemover.IntItemArrayRemover()
        stringItemArrayRemover = ItemArrayRemover.StringItemArrayRemover()
        expressionCalculator = ExpressionCalculator.Base(
            OperandsParser.Base(),
            OperandIndexFromExpressionArrayParser.Base(),
            UnaryMinusParser.UnaryMinusOperandsParser(stringItemArrayRemover),
            UnaryMinusParser.UnaryMinusIndexOperandsParser(intItemArrayRemover),
            VariablesArrayParser.Base(),
            OrderOfOperands.Base(),
            Calculator.Base(intItemArrayRemover, stringItemArrayRemover)
        )
    }
}