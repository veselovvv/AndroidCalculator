package com.veselovvv.androidcalculator.parsers

interface OperandIndexFromExpressionArrayParser {
    fun parse(expression: String, operands: Array<String>): Array<Int>

    class Base : OperandIndexFromExpressionArrayParser, OperandParser.Abstract() {
        // Возвращает массив индексов операндов в выражении:
        override fun parse(expression: String, operands: Array<String>): Array<Int> {
            var indexOperand = 0
            val operandIndexArray = Array(operands.size){0}

            expression.forEachIndexed { index, element ->
                if (isOperand(element)) {
                    operandIndexArray[indexOperand] = index
                    indexOperand++
                }
            }
            return operandIndexArray
        }
    }
}