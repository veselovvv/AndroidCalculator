package com.veselovvv.androidcalculator

interface OrderOfOperands {
    fun orderOfOperands(operands: Array<String>): Array<Int>

    class Base : OrderOfOperands {
        // Возвращает массив индексов порядка выполнения операндов:
        override fun orderOfOperands(operands: Array<String>): Array<Int> {
            val order = Array(operands.size){0}
            var indexOrder = 0

            operands.forEachIndexed { index, element ->
                if (element == "*" || element == "/") {
                    order[indexOrder] = index
                    indexOrder++
                }
            }

            operands.forEachIndexed { index, element ->
                if (element == "+" || element == "-") {
                    order[indexOrder] = index
                    indexOrder++
                }
            }

            return order
        }
    }
}