package com.veselovvv.androidcalculator.calculators

import com.veselovvv.androidcalculator.ItemArrayRemover
import org.junit.Assert.assertEquals
import org.junit.Test

class CalculatorTest {
    private val calculator = Calculator.Base(
        ItemArrayRemover.IntItemArrayRemover(),
        ItemArrayRemover.StringItemArrayRemover()
    )

    @Test
    fun test_calculate() {
        val actual = calculator.calculate(
            arrayOf(6, 3, 5, 8, 16),
            arrayOf("/", "-", "*", "+"),
            arrayOf(0, 1, 2, 3)
        )
        assertEquals("-8", actual)
    }

    @Test
    fun test_operation_variables_add() {
        var actual = calculator.operationVariables(23, 37, "+")
        assertEquals(60, actual)

        actual = calculator.operationVariables(-17, 22, "+")
        assertEquals(5, actual)
    }

    @Test
    fun test_operation_variables_subtract() {
        var actual = calculator.operationVariables(23, 37, "-")
        assertEquals(-14, actual)

        actual = calculator.operationVariables(-17, 22, "-")
        assertEquals(-39, actual)

        actual = calculator.operationVariables(86, 34, "-")
        assertEquals(52, actual)
    }

    @Test
    fun test_operation_variables_multiply() {
        var actual = calculator.operationVariables(15, 4, "*")
        assertEquals(60, actual)

        actual = calculator.operationVariables(15, -4, "*")
        assertEquals(-60, actual)

        actual = calculator.operationVariables(15, 0, "*")
        assertEquals(0, actual)
    }

    @Test
    fun test_operation_variables_divide() {
        var actual = calculator.operationVariables(60, 3, "/")
        assertEquals(20, actual)

        actual = calculator.operationVariables(60, -3, "/")
        assertEquals(-20, actual)
    }
}