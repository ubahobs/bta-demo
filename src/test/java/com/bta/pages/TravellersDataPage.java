package com.bta.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TravellersDataPage {

    private static final SelenideElement
            firstNameInput = $("#travelerFirstName0-text"),
            lastNameInput = $("#travelerLastName0-text"),
            codeInput = $("#travelerIdentityNumber0-text");

    public TravellersDataPage() {
        firstNameInput.shouldBe(visible.because("Travellers Data Page should be loaded"));
    }

    public TravellersDataPage verifyInputsAreEmpty() {
        firstNameInput.shouldBe(empty);
        lastNameInput
                .shouldBe(visible.because("Last Name Input should be visible"))
                .shouldBe(empty);
        codeInput
                .shouldBe(visible.because("Code Input should be visible"))
                .shouldBe(empty);

        return this;
    }

}
