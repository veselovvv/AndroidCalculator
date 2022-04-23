package com.veselovvv.androidcalculator

import android.app.Application
import com.veselovvv.androidcalculator.calculators.Calculator
import com.veselovvv.androidcalculator.calculators.ExpressionCalculator
import com.veselovvv.androidcalculator.parsers.*

class CalculatorApp : Application() {
    lateinit var expressionCalculator: ExpressionCalculator
    private lateinit var itemArrayRemover: ItemArrayRemover

    override fun onCreate() {
        super.onCreate()
        itemArrayRemover = ItemArrayRemover.Base()
        expressionCalculator = ExpressionCalculator.Base(
            OperandsParser.Base(),
            OperandIndexFromExpressionArrayParser.Base(),
            UnaryMinusOperandsParser.Base(itemArrayRemover),
            UnaryMinusIndexOperandsParser.Base(itemArrayRemover),
            VariablesArrayParser.Base(),
            OrderOfOperands.Base(),
            Calculator.Base(itemArrayRemover)
        )
    }
}