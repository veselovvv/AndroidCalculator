package com.veselovvv.androidcalculator.calculators

import com.veselovvv.androidcalculator.ItemArrayRemover
import com.veselovvv.androidcalculator.Operands

interface Calculator {
    fun calculate(variables: Array<Int>, operands: Array<String>, orderOperands: Array<Int>): String
    fun operationVariables(var1: Int, var2: Int, operand: String): Int

    class Base(
        private val intItemArrayRemover: ItemArrayRemover<Int>,
        private val stringItemArrayRemover: ItemArrayRemover<String>
    ) : Calculator, Operands {
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
                tempVarArray = intItemArrayRemover.remove(tempVarArray, indexVar + 1)

                // Удаление операции из массива очереди операций со смещением:
                tempOperands = stringItemArrayRemover.remove(tempOperands, orderOperands[indexOrder])

                orderOperands.forEachIndexed { index, element ->
                    if (element > orderOperands[indexOrder]) orderOperands[index]--
                }
            }
            return tempVarArray[0].toString()
        }

        // Производит операцию:
        override fun operationVariables(var1: Int, var2: Int, operand: String) = when (operand) {
            getAddOperand() -> var1 + var2
            getSubtractOperand() -> var1 - var2
            getMultiplyOperand() -> var1 * var2
            getDivideOperand() -> (var1 / var2) - (var1 % var2)
            else -> 0
        }
    }
}