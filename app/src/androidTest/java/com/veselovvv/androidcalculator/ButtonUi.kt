package com.veselovvv.androidcalculator

import androidx.annotation.IdRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import com.google.android.material.button.MaterialButton
import org.hamcrest.Matchers.allOf

class ButtonUi(@IdRes buttonId: Int) {
    private val interaction: ViewInteraction = onView(
        allOf(
            withParent(withId(R.id.buttons_constraint_layout)),
            withParent(isAssignableFrom(ConstraintLayout::class.java)),
            withId(buttonId),
            isAssignableFrom(MaterialButton::class.java)
        )
    )

    fun checkIsDisplayed() {
        interaction.check(matches(isDisplayed()))
    }

    fun clickButton() {
        interaction.perform(click())
    }
}
