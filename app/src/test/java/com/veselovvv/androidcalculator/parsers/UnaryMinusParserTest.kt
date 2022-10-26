package com.veselovvv.androidcalculator.parsers

import com.veselovvv.androidcalculator.ItemArrayRemover
import org.junit.Assert.assertArrayEquals
import org.junit.Test

class UnaryMinusParserTest {
    @Test
    fun test_unary_minus_operands_parser_parse() {
        val unaryMinusParser =
            UnaryMinusParser.UnaryMinusOperandsParser(ItemArrayRemover.StringItemArrayRemover())
        var expected = arrayOf("/", "-", "*", "+")
        var actual = unaryMinusParser.parse(arrayOf("/", "-", "*", "+"), arrayOf(2, 5, 8, 10))
        assertArrayEquals(expected, actual)

        expected = arrayOf("/", "-", "-", "*", "+")
        actual = unaryMinusParser.parse(arrayOf("/", "-", "-", "*", "+"), arrayOf(2, 4, 7, 9, 12))
        assertArrayEquals(expected, actual)

        expected = arrayOf("/", "-", "*", "+")
        actual = unaryMinusParser.parse(arrayOf("/", "-", "-", "*", "+"), arrayOf(2, 3, 5, 8, 10))
        assertArrayEquals(expected, actual)

        expected = arrayOf("/", "*", "+")
        actual = unaryMinusParser.parse(arrayOf("/", "-", "*", "+"), arrayOf(2, 3, 8, 10))
        assertArrayEquals(expected, actual)
    }

    @Test
    fun test_unary_minus_index_operands_parser_parse() {
        val unaryMinusParser =
            UnaryMinusParser.UnaryMinusIndexOperandsParser(ItemArrayRemover.IntItemArrayRemover())
        var expected = arrayOf(2, 5, 8, 10)
        var actual = unaryMinusParser.parse(arrayOf("/", "-", "*", "+"), arrayOf(2, 5, 8, 10))
        assertArrayEquals(expected, actual)

        expected = arrayOf(2, 4, 7, 9, 12)
        actual = unaryMinusParser.parse(arrayOf("/", "-", "-", "*", "+"), arrayOf(2, 4, 7, 9, 12))
        assertArrayEquals(expected, actual)

        expected = arrayOf(2, 5, 8, 10)
        actual = unaryMinusParser.parse(arrayOf("/", "-", "-", "*", "+"), arrayOf(2, 3, 5, 8, 10))
        assertArrayEquals(expected, actual)

        expected = arrayOf(2, 8, 10)
        actual = unaryMinusParser.parse(arrayOf("/", "-", "*", "+"), arrayOf(2, 3, 8, 10))
        assertArrayEquals(expected, actual)
    }
}