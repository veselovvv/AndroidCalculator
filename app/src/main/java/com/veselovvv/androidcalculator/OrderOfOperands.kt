package com.veselovvv.androidcalculator

interface OrderOfOperands {
    fun orderOfOperands(): Array<Int>
    fun reorganizeOrderForOperands(firstOperand: String, secondOperand: String)

    class Base(private val operands: Array<String>) : OrderOfOperands, Operands {
        private val order = Array(operands.size){0}
        private var indexOrder = 0

        // Возвращает массив индексов порядка выполнения операндов:
        override fun orderOfOperands(): Array<Int> {
            reorganizeOrderForOperands(getMultiplyOperand(), getDivideOperand())
            reorganizeOrderForOperands(getAddOperand(), getSubtractOperand())
            return order
        }

        override fun reorganizeOrderForOperands(firstOperand: String, secondOperand: String) =
            operands.forEachIndexed { index, element ->
                if (element == firstOperand || element == secondOperand) {
                    order[indexOrder] = index
                    indexOrder++
                }
            }
    }
}