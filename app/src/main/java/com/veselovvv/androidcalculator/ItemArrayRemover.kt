package com.veselovvv.androidcalculator

interface ItemArrayRemover<T> {
    fun remove(inputArray: Array<T>, indexRemove: Int): Array<T>

    abstract class Abstract<T> : ItemArrayRemover<T> {
        protected fun remove(resultArray: Array<T>, inputArray: Array<T>, indexRemove: Int): Array<T> {
            resultArray.forEachIndexed { index, _ ->
                if (index >= indexRemove) resultArray[index] = inputArray[index + 1]
                else resultArray[index] = inputArray[index]
            }
            return resultArray
        }
    }

    // Удаляет элемент из массива чисел:
    class IntItemArrayRemover : Abstract<Int>() {
        override fun remove(inputArray: Array<Int>, indexRemove: Int): Array<Int> {
            val resultArray = Array(inputArray.size - 1){0}
            return remove(resultArray, inputArray, indexRemove)
        }
    }

    // Удаляет элемент из массива строк:
    class StringItemArrayRemover : Abstract<String>() {
        override fun remove(inputArray: Array<String>, indexRemove: Int): Array<String> {
            val resultArray = Array(inputArray.size - 1){""}
            return remove(resultArray, inputArray, indexRemove)
        }
    }
}