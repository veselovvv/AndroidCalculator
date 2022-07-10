package com.veselovvv.androidcalculator.parsers

interface VariablesArrayParser {
    fun parse(expression: String, operandsIndex: Array<Int>): Array<Int>

    class Base : VariablesArrayParser {
        // Разбивает выражение на переменные:
        override fun parse(expression: String, operandsIndex: Array<Int>): Array<Int> {
            val variablesStr = Array(operandsIndex.size + 1){""}
            val variablesInt = Array(operandsIndex.size + 1){0}
            var indexOperands = 0   // индекс массива индексов операндов
            var indexVar = 0        // индекс массива переменных

            expression.forEachIndexed { index, element -> // перебор строки с выражением
                if (index != operandsIndex[indexOperands])
                    variablesStr[indexVar] += element.toString() // переложить в отдельный массив с элементами

                if (index == operandsIndex[indexOperands]) { // если попали на индекс операнда,
                    indexVar++
                    if (indexOperands < operandsIndex.lastIndex) indexOperands++
                }
            }

            // Перевод всех элементов массива в целочисленный формат:
            variablesStr.forEachIndexed { index, element ->
                variablesStr[index] = variablesStr[index].replace("(", "")
                variablesStr[index] = variablesStr[index].replace(")", "")
                variablesInt[index] = element.toInt()
            }
            return variablesInt
        }
    }
}