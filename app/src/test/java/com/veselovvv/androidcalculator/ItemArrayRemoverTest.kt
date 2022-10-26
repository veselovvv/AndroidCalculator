package com.veselovvv.androidcalculator

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class ItemArrayRemoverTest {
    @Test
    fun test_int_item_array_remover_remove() {
        val itemArrayRemover = ItemArrayRemover.IntItemArrayRemover()
        val expected = arrayOf(6, 5, 8, 16)
        val actual = itemArrayRemover.remove(arrayOf(6, 3, 5, 8, 16), 1)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun test_string_item_array_remover_remove() {
        val itemArrayRemover = ItemArrayRemover.StringItemArrayRemover()
        val expected = arrayOf("-", "*", "+")
        val actual = itemArrayRemover.remove(arrayOf("/", "-", "*", "+"), 0)
        assertArrayEquals(expected, actual)
    }
}