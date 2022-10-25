package com.veselovvv.androidcalculator.parsers

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class OperandsParserTest {
    @Test
    fun test_parse() {
        val expected = arrayOf("/", "-", "*", "+")
        val actual = OperandsParser.Base().parse("23/37-45*8+16")
        assertArrayEquals(expected, actual)
    }
}