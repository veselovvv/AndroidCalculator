package com.veselovvv.androidcalculator

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.google.android.material.textfield.TextInputEditText
import org.hamcrest.Matchers.allOf

class EditTextStateUi {
    private val interaction: ViewInteraction = onView(
        allOf(
            withParent(withId(R.id.text_fields_constraint_layout)),
            withParent(isAssignableFrom(ConstraintLayout::class.java)),
            withId(R.id.expression_edit_text),
            isAssignableFrom(TextInputEditText::class.java)
        )
    )

    fun checkInitialState() {
        interaction.check(matches(isDisplayed()))
        interaction.check(matches(withHint("Enter an expression")))
        checkState(text = "")
    }

    fun typeIn(text: String) {
        interaction.perform(clearText()).perform(typeText(text))
    }

    fun checkState(text: String) {
        interaction.check(matches(withText(text)))
    }
}
