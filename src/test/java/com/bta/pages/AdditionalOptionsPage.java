package com.bta.pages;

import com.bta.base.PageBase;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AdditionalOptionsPage extends PageBase {

    private float totalSum;

    private static final SelenideElement
        header = $(".header h2"),
        extraCoverForm = $(".travel-insurance-option"),
        sumField = $(".sum"),
        editButton = $("#additional-options section button"),
        insuranceSumInput = $("#deductible-open"),
        insuranceSumSecondOption = $("#deductible-dropdown-select-option-1"),
        confirmButton = $(".rental-settings .background-red"),
        continueButton = $("#insurance-plan-widget button");

    public AdditionalOptionsPage() {
        super();
        header.shouldBe(visible.because("Additional Page should be loaded"), Duration.ofMillis(timeout));
        this.totalSum = Float.parseFloat(sumField
                .shouldBe(visible.because("Total Sum should be visible"))
                .getText());
    }

    @Step
    public AdditionalOptionsPage verifyForms() {
        header.shouldHave(text("Vēlies pievienot papildu aizsardzību?"));
        extraCoverForm.shouldBe(visible.because("Extra Cover Form should be visible"));

        return this;
    }

    @Step
    public AdditionalOptionsPage changeInsuranceSum() {
        editButton
                .shouldBe(visible.because("Edit Button should be visible"))
                .click();
        insuranceSumInput
                .shouldBe(visible.because("Insurance Sum Input should be visible"))
                .click();
        insuranceSumSecondOption
                .shouldBe(visible.because("Insurance Sum Second Option should be visible"))
                .click();
        confirmButton
                .shouldBe(visible.because("Confirm Button should be visible"))
                .click();

        Assert.assertTrue(Float.parseFloat(sumField.getText()) > totalSum,
                "Sum value should be higher than " + totalSum);

        return this;
    }

    @Step
    public TravellersDataPage navigateToTravellerPage() {
        continueButton
                .shouldBe(visible.because("Continue Button should be visible"))
                .click();

        return new TravellersDataPage();
    }

}
