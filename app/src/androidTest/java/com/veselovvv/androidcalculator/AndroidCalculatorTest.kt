package com.veselovvv.androidcalculator

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AndroidCalculatorTest {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    /**
     * Check initial ui state
     * 1. Type in edit text "23+37"
     * Check edit text state with text "23+37"
     * 2. Recreate activity
     * Check edit text state with text "23+37"
     * 3. Click result button
     * Check edit text state with text "23+37"
     * Check result text view state with text "60"
     * 4. Type in edit text "-17+22"
     * Check edit text state with text "-17+22"
     * 5. Recreate activity
     * Check edit text state with text "-17+22"
     * 6. Click result button
     * Check edit text state with text "-17+22"
     * Check result text view state with text "5"
     */
    @Test
    fun testAdd() = with(MainPage()) {
        checkInitialUiState()
        typeInEditText(text = "23+37")
        checkEditTextState(text = "23+37")

        activityScenarioRule.scenario.recreate()
        checkEditTextState(text = "23+37")

        clickResultButton()
        checkEditTextState(text = "23+37")
        checkResultTextViewState(text = "60")

        typeInEditText(text = "-17+22")
        checkEditTextState(text = "-17+22")

        activityScenarioRule.scenario.recreate()
        checkEditTextState(text = "-17+22")

        clickResultButton()
        checkEditTextState(text = "-17+22")
        checkResultTextViewState(text = "5")
    }

    /**
     * Check initial ui state
     * 1. Type in edit text "23-37"
     * Check edit text state with text "23-37"
     * 2. Recreate activity
     * Check edit text state with text "23-37"
     * 3. Click result button
     * Check edit text state with text "23-37"
     * Check result text view state with text "-14"
     * 4. Type in edit text "-17-22"
     * Check edit text state with text "-17-22"
     * 5. Recreate activity
     * Check edit text state with text "-17-22"
     * 6. Click result button
     * Check edit text state with text "-17-22"
     * Check result text view state with text "-39"
     * 7. Type in edit text "86-34"
     * Check edit text state with text "86-34"
     * 8. Recreate activity
     * Check edit text state with text "86-34"
     * 9. Click result button
     * Check edit text state with text "86-34"
     * Check result text view state with text "52"
     */
    @Test
    fun testSubtract() = with(MainPage()) {
        checkInitialUiState()
        typeInEditText(text = "23-37")
        checkEditTextState(text = "23-37")

        activityScenarioRule.scenario.recreate()
        checkEditTextState(text = "23-37")

        clickResultButton()
        checkEditTextState(text = "23-37")
        checkResultTextViewState(text = "-14")

        typeInEditText(text = "-17-22")
        checkEditTextState(text = "-17-22")

        activityScenarioRule.scenario.recreate()
        checkEditTextState(text = "-17-22")

        clickResultButton()
        checkEditTextState(text = "-17-22")
        checkResultTextViewState(text = "-39")

        typeInEditText(text = "86-34")
        checkEditTextState(text = "86-34")

        activityScenarioRule.scenario.recreate()
        checkEditTextState(text = "86-34")

        clickResultButton()
        checkEditTextState(text = "86-34")
        checkResultTextViewState(text = "52")
    }

    /**
     * Check initial ui state
     * 1. Type in edit text "15*4"
     * Check edit text state with text "15*4"
     * 2. Recreate activity
     * Check edit text state with text "15*4"
     * 3. Click result button
     * Check edit text state with text "15*4"
     * Check result text view state with text "60"
     * 4. Type in edit text "15*-4"
     * Check edit text state with text "15*-4"
     * 5. Recreate activity
     * Check edit text state with text "15*-4"
     * 6. Click result button
     * Check edit text state with text "15*-4"
     * Check result text view state with text "-60"
     * 7. Type in edit text "15*0"
     * Check edit text state with text "15*0"
     * 8. Recreate activity
     * Check edit text state with text "15*0"
     * 9. Click result button
     * Check edit text state with text "15*0"
     * Check result text view state with text "0"
     */
    @Test
    fun testMultiply() = with(MainPage()) {
        checkInitialUiState()
        typeInEditText(text = "15*4")
        checkEditTextState(text = "15*4")

        activityScenarioRule.scenario.recreate()
        checkEditTextState(text = "15*4")

        clickResultButton()
        checkEditTextState(text = "15*4")
        checkResultTextViewState(text = "60")

        typeInEditText(text = "15*-4")
        checkEditTextState(text = "15*-4")

        activityScenarioRule.scenario.recreate()
        checkEditTextState(text = "15*-4")

        clickResultButton()
        checkEditTextState(text = "15*-4")
        checkResultTextViewState(text = "-60")

        typeInEditText(text = "15*0")
        checkEditTextState(text = "15*0")

        activityScenarioRule.scenario.recreate()
        checkEditTextState(text = "15*0")

        clickResultButton()
        checkEditTextState(text = "15*0")
        checkResultTextViewState(text = "0")
    }

    /**
     * Check initial ui state
     * 1. Type in edit text "60/3"
     * Check edit text state with text "60/3"
     * 2. Recreate activity
     * Check edit text state with text "60/3"
     * 3. Click result button
     * Check edit text state with text "60/3"
     * Check result text view state with text "20"
     * 4. Type in edit text "60/-3"
     * Check edit text state with text "60/-3"
     * 5. Recreate activity
     * Check edit text state with text "60/-3"
     * 6. Click result button
     * Check edit text state with text "60/-3"
     * Check result text view state with text "-20"
     */
    @Test
    fun testDivide() = with(MainPage()) {
        checkInitialUiState()
        typeInEditText(text = "60/3")
        checkEditTextState(text = "60/3")

        activityScenarioRule.scenario.recreate()
        checkEditTextState(text = "60/3")

        clickResultButton()
        checkEditTextState(text = "60/3")
        checkResultTextViewState(text = "20")

        typeInEditText(text = "60/-3")
        checkEditTextState(text = "60/-3")

        activityScenarioRule.scenario.recreate()
        checkEditTextState(text = "60/-3")

        clickResultButton()
        checkEditTextState(text = "60/-3")
        checkResultTextViewState(text = "-20")
    }

    /**
     * Check initial ui state
     * 1. Type in edit text "6/3-5*8+16"
     * Check edit text state with text "6/3-5*8+16"
     * 2. Recreate activity
     * Check edit text state with text "6/3-5*8+16"
     * 3. Click result button
     * Check edit text state with text "6/3-5*8+16"
     * Check result text view state with text "-22"
     */
    @Test
    fun testComplexExpression() = with(MainPage()) {
        checkInitialUiState()
        typeInEditText(text = "6/3-5*8+16")
        checkEditTextState(text = "6/3-5*8+16")

        activityScenarioRule.scenario.recreate()
        checkEditTextState(text = "6/3-5*8+16")

        clickResultButton()
        checkEditTextState(text = "6/3-5*8+16")
        checkResultTextViewState(text = "-22")
    }

    /**
     * Check initial ui state
     * 1. Type in edit text "6/3-5*8+16"
     * Check edit text state with text "6/3-5*8+16"
     * 2. Click clear button
     * Check initial ui state
     * 3. Recreate activity
     * Check initial ui state
     */
    @Test
    fun testClear() = with(MainPage()) {
        checkInitialUiState()
        typeInEditText(text = "6/3-5*8+16")
        checkEditTextState(text = "6/3-5*8+16")

        clickClearButton()
        checkInitialUiState()

        activityScenarioRule.scenario.recreate()
        checkInitialUiState()
    }
}