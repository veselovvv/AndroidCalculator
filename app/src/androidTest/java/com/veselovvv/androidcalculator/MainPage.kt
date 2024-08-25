package com.veselovvv.androidcalculator

class MainPage {
    private val editTextStateUi = EditTextStateUi()
    private val resultButtonUi = ButtonUi(buttonId = R.id.result_button)
    private val clearButtonUi = ButtonUi(buttonId = R.id.clear_button)
    private val resultTextViewUi = ResultTextViewUi()

    fun checkInitialUiState() {
        resultButtonUi.checkIsDisplayed()
        clearButtonUi.checkIsDisplayed()
        editTextStateUi.checkInitialState()
        resultTextViewUi.checkInitialState()
    }

    fun typeInEditText(text: String) = editTextStateUi.typeIn(text = text)
    fun checkEditTextState(text: String) = editTextStateUi.checkState(text = text)
    fun clickResultButton() = resultButtonUi.clickButton()
    fun clickClearButton() = clearButtonUi.clickButton()
    fun checkResultTextViewState(text: String) = resultTextViewUi.checkState(text = text)
}
