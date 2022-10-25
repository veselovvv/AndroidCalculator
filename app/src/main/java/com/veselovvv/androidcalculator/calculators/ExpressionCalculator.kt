package com.veselovvv.androidcalculator.calculators

import com.veselovvv.androidcalculator.OrderOfOperands
import com.veselovvv.androidcalculator.parsers.OperandIndexFromExpressionArrayParser
import com.veselovvv.androidcalculator.parsers.OperandsParser
import com.veselovvv.androidcalculator.parsers.UnaryMinusParser
import com.veselovvv.androidcalculator.parsers.VariablesArrayParser

interface ExpressionCalculator {
    fun doExpression(expression: String): String

    class Base(
        private val operandsParser: OperandsParser,
        private val operandIndexFromExpressionArrayParser: OperandIndexFromExpressionArrayParser,
        private val unaryMinusOperandsParser: UnaryMinusParser<String>,
        private val unaryMinusIndexOperandsParser: UnaryMinusParser<Int>,
        private val variablesArrayParser: VariablesArrayParser,
        private val calculator: Calculator
    ) : ExpressionCalculator {
        // Парсит строку на переменные и операнды для выполнения операций:
        override fun doExpression(expression: String): String {
            var operandsArray = operandsParser.parse(expression)
            var indexOperandsArray =
                operandIndexFromExpressionArrayParser.parse(expression, operandsArray)

            val tempOperandsArray = unaryMinusOperandsParser.parse(operandsArray, indexOperandsArray)
            val tempIndexOperandsArray =
                unaryMinusIndexOperandsParser.parse(operandsArray, indexOperandsArray)

            indexOperandsArray = tempIndexOperandsArray
            operandsArray = tempOperandsArray

            val variablesArray = variablesArrayParser.parse(expression, indexOperandsArray)
            val orderOperandsArray = OrderOfOperands.Base(operandsArray).orderOfOperands()
            return calculator.calculate(variablesArray, operandsArray, orderOperandsArray)
        }
    }
}