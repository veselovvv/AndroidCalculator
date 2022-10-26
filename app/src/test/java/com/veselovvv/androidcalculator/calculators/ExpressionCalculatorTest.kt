package com.veselovvv.androidcalculator.calculators

import com.veselovvv.androidcalculator.ItemArrayRemover
import com.veselovvv.androidcalculator.parsers.OperandIndexFromExpressionArrayParser
import com.veselovvv.androidcalculator.parsers.OperandsParser
import com.veselovvv.androidcalculator.parsers.UnaryMinusParser
import com.veselovvv.androidcalculator.parsers.VariablesArrayParser
import org.junit.Assert.assertEquals
import org.junit.Test

class ExpressionCalculatorTest {
    @Test
    fun test_do_expression() {
        val intItemArrayRemover = ItemArrayRemover.IntItemArrayRemover()
        val stringItemArrayRemover = ItemArrayRemover.StringItemArrayRemover()

        val expressionCalculator = ExpressionCalculator.Base(
            OperandsParser.Base(),
            OperandIndexFromExpressionArrayParser.Base(),
            UnaryMinusParser.UnaryMinusOperandsParser(stringItemArrayRemover),
            UnaryMinusParser.UnaryMinusIndexOperandsParser(intItemArrayRemover),
            VariablesArrayParser.Base(),
            Calculator.Base(intItemArrayRemover, stringItemArrayRemover)
        )

        val actual = expressionCalculator.doExpression("6/3-5*8+16")
        assertEquals("-22", actual)
    }
}