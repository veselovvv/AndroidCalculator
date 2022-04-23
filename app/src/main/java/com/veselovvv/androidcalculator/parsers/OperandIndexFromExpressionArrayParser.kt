package com.veselovvv.androidcalculator.parsers

interface OperandIndexFromExpressionArrayParser {
    fun parseOperandIndexFromExpressionArray(expression: String, operands: Array<String>): Array<Int>

    class Base : OperandIndexFromExpressionArrayParser {
        // Возвращает массив индексов операндов в выражении:
        override fun parseOperandIndexFromExpressionArray(
            expression: String, operands: Array<String>
        ): Array<Int> {
            var indexOperand = 0
            val operandIndexArray = Array(operands.size){0}

            expression.forEachIndexed { index, element ->
                if ((element == '+') || (element == '-') || (element == '*') || (element == '/')) {
                    operandIndexArray[indexOperand] = index
                    indexOperand++
                }
            }
            return operandIndexArray
        }
    }
}