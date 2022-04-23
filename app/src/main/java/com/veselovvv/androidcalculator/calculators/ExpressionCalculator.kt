package com.veselovvv.androidcalculator.calculators

import com.veselovvv.androidcalculator.OrderOfOperands
import com.veselovvv.androidcalculator.parsers.*

interface ExpressionCalculator {
    fun doExpression(expression: String): String

    class Base(
        private val operandsParser: OperandsParser,
        private val operandIndexFromExpressionArrayParser: OperandIndexFromExpressionArrayParser,
        private val unaryMinusOperandsParser: UnaryMinusOperandsParser,
        private val unaryMinusIndexOperandsParser: UnaryMinusIndexOperandsParser,
        private val variablesArrayParser: VariablesArrayParser,
        private val orderOfOperands: OrderOfOperands,
        private val calculator: Calculator
    ) : ExpressionCalculator {
        // Парсит строку на переменные и операнды для выполнения операций:
        override fun doExpression(expression: String): String {
            var operandsArray = operandsParser.parseOperands(expression)
            var indexOperandsArray =
                operandIndexFromExpressionArrayParser.parseOperandIndexFromExpressionArray(
                    expression,
                    operandsArray
                )

            val tempOperandsArray =
                unaryMinusOperandsParser.parseUnaryMinusOperands(operandsArray, indexOperandsArray)
            val tempIndexOperandsArray = unaryMinusIndexOperandsParser.parseUnaryMinusIndexOperands(
                operandsArray,
                indexOperandsArray
            )

            indexOperandsArray = tempIndexOperandsArray
            operandsArray = tempOperandsArray

            val variablesArray = variablesArrayParser.parseVariablesArray(expression, indexOperandsArray)
            val orderOperandsArray = orderOfOperands.orderOfOperands(operandsArray)
            return calculator.calculate(variablesArray, operandsArray, orderOperandsArray)
        }
    }
}