package com.veselovvv.androidcalculator.calculators

import com.veselovvv.androidcalculator.ItemArrayRemover

interface Calculator {
    fun calculate(variables: Array<Int>, operands: Array<String>, orderOperands: Array<Int>): String
    fun operationVariables(var1: Int, var2: Int, operand: String): Int

    class Base(private val itemArrayRemover: ItemArrayRemover) : Calculator {
        // Вычисляет по приоритетам операций, перебирая массивы элементов:
        override fun calculate(
            variables: Array<Int>, operands: Array<String>, orderOperands: Array<Int>
        ): String {
            var tempVarArray = variables
            var tempOperands = operands
            var indexVar: Int

            for (indexOrder in orderOperands.indices) { // перебор в массиве очереди операций
                indexVar = orderOperands[indexOrder]

                // В определенный элемент массива добавляется расчитанное значение согласно операнду:
                tempVarArray[indexVar] = operationVariables(
                    tempVarArray[indexVar],
                    tempVarArray[indexVar + 1],
                    tempOperands[orderOperands[indexOrder]]
                )

                // Удаление след. элемента из массива со смещением:
                tempVarArray = itemArrayRemover.removeItemArrayInt(tempVarArray, indexVar + 1)

                // Удаление операции из массива очереди операций со смещением:
                tempOperands =
                    itemArrayRemover.removeItemArrayString(tempOperands, orderOperands[indexOrder])

                orderOperands.forEachIndexed { index, element ->
                    if (element > orderOperands[indexOrder]) orderOperands[index]--
                }
            }
            return tempVarArray[0].toString()
        }

        // Производит операцию:
        override fun operationVariables(var1: Int, var2: Int, operand: String) = when (operand) {
            "+" -> var1 + var2
            "-" -> var1 - var2
            "*" -> var1 * var2
            "/" -> (var1 / var2) - (var1 % var2)
            else -> 0
        }
    }
}