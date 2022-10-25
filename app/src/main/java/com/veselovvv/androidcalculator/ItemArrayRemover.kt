package com.veselovvv.androidcalculator

interface ItemArrayRemover<T> {
    fun remove(inputArray: Array<T>, indexRemove: Int): Array<T>

    abstract class Abstract<T> : ItemArrayRemover<T> {
        protected fun remove(
            inputArray: Array<T>,
            indexRemove: Int,
            resultArray: () -> Array<T>
        ): Array<T> {
            val array = resultArray.invoke()
            array.forEachIndexed { index, _ ->
                array[index] = if (index >= indexRemove) inputArray[index + 1] else inputArray[index]
            }
            return array
        }
    }

    // Удаляет элемент из массива чисел:
    class IntItemArrayRemover : Abstract<Int>() {
        override fun remove(inputArray: Array<Int>, indexRemove: Int): Array<Int> =
            remove(inputArray, indexRemove) {
                Array(inputArray.size - 1) { 0 }
            }
    }

    // Удаляет элемент из массива строк:
    class StringItemArrayRemover : Abstract<String>() {
        override fun remove(inputArray: Array<String>, indexRemove: Int): Array<String> =
            remove(inputArray, indexRemove) {
                Array(inputArray.size - 1) { "" }
            }
    }
}