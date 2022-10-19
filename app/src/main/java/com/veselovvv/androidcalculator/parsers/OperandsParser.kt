package com.veselovvv.androidcalculator.parsers

interface OperandsParser {
    fun parse(expression: String): Array<String>

    class Base : OperandsParser, OperandParser.Abstract() {
        // Находит операнды в строке:
        override fun parse(expression: String): Array<String> {
            var indexOperand = 0
            var countOperand = 0

            // Количество операндов для создания массива:
            expression.forEach { element ->
                if (isOperand(element)) countOperand++
            }

            val operandsArray = Array(countOperand){""}

            // Поиск операндов:
            expression.forEach { element ->
                // Если в строке выражения есть операнд, добавить его в массив операндов:
                if (isOperand(element)) {
                    operandsArray[indexOperand] = element.toString()
                    indexOperand++
                }
            }
            return operandsArray
        }
    }
}