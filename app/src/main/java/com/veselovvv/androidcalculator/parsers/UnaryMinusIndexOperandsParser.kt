package com.veselovvv.androidcalculator.parsers

import com.veselovvv.androidcalculator.ItemArrayRemover

interface UnaryMinusIndexOperandsParser {
    fun parseUnaryMinusIndexOperands(operands: Array<String>, indexOperands: Array<Int>): Array<Int>

    class Base(private val itemArrayRemover: ItemArrayRemover) : UnaryMinusIndexOperandsParser {
        // Проверяет на наличие унарного минуса перед переменной и удаляет из массива индексов операндов:
        override fun parseUnaryMinusIndexOperands(
            operands: Array<String>, indexOperands: Array<Int>
        ): Array<Int> {
            var tempIndexOperands = indexOperands

            if (operands[0] == "-" && indexOperands[0] == 0) {
                tempIndexOperands = itemArrayRemover.removeItemArrayInt(tempIndexOperands, 0)
            }

            indexOperands.forEachIndexed { index, element ->
                if (index <= indexOperands.lastIndex - 1) {
                    if (indexOperands[index + 1] - element == 1 && (operands[index + 1] == "-")) {
                        tempIndexOperands =
                            itemArrayRemover.removeItemArrayInt(tempIndexOperands, index + 1)
                    }
                }
            }

            return tempIndexOperands
        }
    }
}