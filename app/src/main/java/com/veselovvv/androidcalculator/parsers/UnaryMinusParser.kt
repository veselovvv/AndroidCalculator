package com.veselovvv.androidcalculator.parsers

import com.veselovvv.androidcalculator.ItemArrayRemover
import com.veselovvv.androidcalculator.Operands

interface UnaryMinusParser<T> {
    fun parse(operands: Array<String>, indexOperands: Array<Int>): Array<T>

    abstract class Abstract<T>(
        private val itemArrayRemover: ItemArrayRemover<T>
    ) : UnaryMinusParser<T>, Operands {
        protected fun parse(
            operands: Array<String>, indexOperands: Array<Int>, tempArray: () -> Array<T>
        ): Array<T> {
            var resultArray = tempArray.invoke()

            if (operands[0] == getSubtractOperand() && indexOperands[0] == 0)
                resultArray = itemArrayRemover.remove(resultArray, 0)

            indexOperands.forEachIndexed { index, element ->
                if (index <= indexOperands.lastIndex - 1) {
                    if (indexOperands[index + 1] - element == 1 && (operands[index + 1] == getSubtractOperand()))
                        resultArray = itemArrayRemover.remove(resultArray, index + 1)
                }
            }
            return resultArray
        }
    }

    class UnaryMinusOperandsParser(
        itemArrayRemover: ItemArrayRemover<String>
    ) : Abstract<String>(itemArrayRemover) {
        // Проверяет на наличие унарного минуса перед переменной и удаляет операнд из массива операндов:
        override fun parse(operands: Array<String>, indexOperands: Array<Int>) =
            parse(operands, indexOperands) { operands }
    }

    class UnaryMinusIndexOperandsParser(
        itemArrayRemover: ItemArrayRemover<Int>
    ) : Abstract<Int>(itemArrayRemover) {
        // Проверяет на наличие унарного минуса перед переменной и удаляет из массива индексов операндов:
        override fun parse(operands: Array<String>, indexOperands: Array<Int>) =
            parse(operands, indexOperands) { indexOperands }
    }
}