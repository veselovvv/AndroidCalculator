package com.veselovvv.androidcalculator.parsers

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class OperandIndexFromExpressionArrayParserTest {
    @Test
    fun test_parse() {
        val expected = arrayOf(2, 5, 8, 10)
        val actual = OperandIndexFromExpressionArrayParser.Base().parse(
            "23/37-45*8+16",
            arrayOf("/", "-", "*", "+")
        )
        assertArrayEquals(expected, actual)
    }
}