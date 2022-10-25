package com.veselovvv.androidcalculator

interface Operands {
    fun getAddOperand() = ADD_OPERAND
    fun getSubtractOperand() = SUBTRACT_OPERAND
    fun getMultiplyOperand() = MULTIPLY_OPERAND
    fun getDivideOperand() = DIVIDE_OPERAND

    companion object {
        private const val ADD_OPERAND = "+"
        private const val SUBTRACT_OPERAND = "-"
        private const val MULTIPLY_OPERAND = "*"
        private const val DIVIDE_OPERAND = "/"
    }
}