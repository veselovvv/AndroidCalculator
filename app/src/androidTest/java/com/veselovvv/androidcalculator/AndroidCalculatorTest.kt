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
}