package com.veselovvv.androidcalculator.parsers

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class VariablesArrayParserTest {
    @Test
    fun test_parse() {
        val expected = arrayOf(23, 37, 45, 8, 16)
        val actual = VariablesArrayParser.Base().parse("23/37-45*8+16", arrayOf(2, 5, 8, 10))
        assertArrayEquals(expected, actual)
    }
}