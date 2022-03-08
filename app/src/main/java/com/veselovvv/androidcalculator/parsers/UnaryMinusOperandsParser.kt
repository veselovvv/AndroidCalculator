package com.veselovvv.androidcalculator.parsers

import com.veselovvv.androidcalculator.ItemArrayRemover

interface UnaryMinusOperandsParser {
    fun parseUnaryMinusOperands(operands: Array<String>, indexOperands: Array<Int>): Array<String>

    class Base(private val itemArrayRemover: ItemArrayRemover) : UnaryMinusOperandsParser {
        // Проверят на наличие унарного минуса перед переменной и удаляет операнд из массива операндов:
        override fun parseUnaryMinusOperands(
            operands: Array<String>, indexOperands: Array<Int>
        ): Array<String> {
            var tempOperands = operands

            if (operands[0] == "-" && indexOperands[0] == 0) {
                tempOperands = itemArrayRemover.removeItemArrayString(tempOperands, 0)
            }

            indexOperands.forEachIndexed { index, element ->
                if (index <= indexOperands.lastIndex - 1) {
                    if (indexOperands[index + 1] - element == 1 && (operands[index + 1] == "-")) {
                        tempOperands =
                            itemArrayRemover.removeItemArrayString(tempOperands, index + 1)
                    }
                }
            }

            return tempOperands
        }
    }
}