package com.veselovvv.androidcalculator

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.google.android.material.textview.MaterialTextView
import org.hamcrest.Matchers.allOf

class ResultTextViewUi {
    private val interaction: ViewInteraction = onView(
        allOf(
            withParent(withId(R.id.text_fields_constraint_layout)),
            withParent(isAssignableFrom(ConstraintLayout::class.java)),
            withId(R.id.result_text_view),
            isAssignableFrom(MaterialTextView::class.java)
        )
    )

    fun checkInitialState() {
        interaction.check(matches(isDisplayed()))
        checkState("Result")
    }

    fun checkState(text: String) {
        interaction.check(matches(withText(text)))
    }
}
