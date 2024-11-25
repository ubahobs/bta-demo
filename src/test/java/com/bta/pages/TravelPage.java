package com.bta.pages;

import com.bta.base.PageBase;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class TravelPage extends PageBase {

    private static final SelenideElement
            destinationInput = $("#regionalSelectorRegion-open"),
            selectCountriesOption = $("#regionalSelectorCountry-showListSearch"),
            addCountryButton = $("#regionalSelectorCountry-addCountry"),
            addCountryInput = $("#regionalSelectorCountry-typedValue"),
            indiaOption = $("[data-value='Indija']"),
            appliedCountryOption = $("#regionalSelectorCountry-removeCountry-0"),
            applyButton = $("#regionalSelectorCountry-applyButton"),
            activitiesInput = $("#travelActivities-open"),
            highRiskOption = $("#travelActivities-popup-select-option-1"),
            calculateButton = $("[data-type='travelSubmit']");


    public TravelPage() {
        super();
        destinationInput.shouldBe(visible.because("Travel Page should be loaded"), Duration.ofMillis(timeout));
    }

    @Step
    public TravelPage applyWorldwideTravelDestination() {
        destinationInput.click();
        selectCountriesOption
                .shouldBe(visible.because("Select Countries Option should be visible"))
                .click();
        addCountryButton
                .shouldBe(visible.because("Add Country Button should be visible"))
                .click();
        addCountryInput
                .shouldBe(visible.because("Add Country Input should be visible"))
                .setValue("Indija");
        indiaOption
                .shouldBe(visible.because("India Option should be visible"))
                .click();
        appliedCountryOption
                .shouldBe(visible.because("India Option should be visible"))
                .shouldHave(text("Indija"));
        applyButton
                .shouldBe(visible.because("Apply Button should be visible"))
                .click();
        destinationInput.shouldHave(text("Visa pasaule"));

        return this;
    }

    @Step
    public TravelPage applyWithHighRiskActivities() {
        activitiesInput
                .shouldBe(visible.because("Activities Input should be visible"))
                .click();
        highRiskOption
                .shouldBe(visible.because("High Risk Button should be visible"))
                .click();
        activitiesInput.shouldHave(text("Ar paaugstināta riska aktivitātēm"));

        return this;
    }

    @Step
    public PolicyPage navigateToPolicyPricingPage() {
        actions().moveToElement(calculateButton).perform();
        calculateButton
                .shouldBe(visible.because("Calculate Button should be visible"))
                .click();

        return new PolicyPage();
    }
}
