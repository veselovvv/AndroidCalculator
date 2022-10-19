package com.veselovvv.androidcalculator

interface OrderOfOperands {
    fun orderOfOperands(operands: Array<String>): Array<Int>

    class Base : OrderOfOperands {
        // Возвращает массив индексов порядка выполнения операндов:
        override fun orderOfOperands(operands: Array<String>): Array<Int> {
            val order = Array(operands.size){0}
            var indexOrder = 0

            operands.forEachIndexed { index, element ->
                if (element == MULTIPLY_OPERAND || element == DIVIDE_OPERAND) {
                    order[indexOrder] = index
                    indexOrder++
                }
            }

            operands.forEachIndexed { index, element ->
                if (element == ADD_OPERAND || element == SUBTRACT_OPERAND) {
                    order[indexOrder] = index
                    indexOrder++
                }
            }
            return order
        }

        companion object {
            private const val ADD_OPERAND = "+"
            private const val SUBTRACT_OPERAND = "-"
            private const val MULTIPLY_OPERAND = "*"
            private const val DIVIDE_OPERAND = "/"
        }
    }
}