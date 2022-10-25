package com.veselovvv.androidcalculator.parsers

interface OperandParser {
    // Возвращает true если элемент - операнд
    fun isOperand(element: Char) =
        (element == ADD_OPERAND) || (element == SUBTRACT_OPERAND) ||
                (element == MULTIPLY_OPERAND) || (element == DIVIDE_OPERAND)

    companion object {
        private const val ADD_OPERAND = '+'
        private const val SUBTRACT_OPERAND = '-'
        private const val MULTIPLY_OPERAND = '*'
        private const val DIVIDE_OPERAND = '/'
    }
}