package com.veselovvv.androidcalculator

interface ItemArrayRemover {
    fun removeItemArrayInt(inputArray: Array<Int>, indexRemove: Int): Array<Int>
    fun removeItemArrayString(inputArray: Array<String>, indexRemove: Int): Array<String>

    class Base : ItemArrayRemover {
        // Удаляет элемент из массива чисел:
        override fun removeItemArrayInt(inputArray: Array<Int>, indexRemove: Int): Array<Int> {
            val resultArray = Array(inputArray.size - 1){0}

            resultArray.forEachIndexed { index, _ ->
                if (index >= indexRemove) resultArray[index] = inputArray[index + 1]
                else resultArray[index] = inputArray[index]
            }

            return resultArray
        }

        // Удаляет элемент из массива строк:
        override fun removeItemArrayString(inputArray: Array<String>, indexRemove: Int): Array<String> {
            val resultArray = Array(inputArray.size - 1){""}

            resultArray.forEachIndexed { index, _ ->
                if (index >= indexRemove) resultArray[index] = inputArray[index + 1]
                else resultArray[index] = inputArray[index]
            }

            return resultArray
        }
    }
}