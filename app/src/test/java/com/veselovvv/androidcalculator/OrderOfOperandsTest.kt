package com.veselovvv.androidcalculator

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class OrderOfOperandsTest {
    @Test
    fun test_order_of_operands() {
        val orderOfOperands = OrderOfOperands.Base(arrayOf("/", "-", "*", "+"))
        val expected = arrayOf(0, 2, 1, 3)
        val actual = orderOfOperands.orderOfOperands()
        assertArrayEquals(expected, actual)
    }
}