package com.bta.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TravelPage {

    private static final SelenideElement
            destinationInput = $("#regionalSelectorRegion-open"),
            selectCountriesOption = $("#regionalSelectorCountry-showListSearch"),
            addCountryButton = $("#regionalSelectorCountry-addCountry"),
            addCountryInput = $("#regionalSelectorCountry-typedValue"),
            indiaOption = $("[data-value='India']"),
            appliedCountryOption = $("#regionalSelectorCountry-removeCountry-0"),
            applyButton = $("#regionalSelectorCountry-applyButton"),
            activitiesInput = $("#travelActivities-open"),
            highRiskOption = $("#travelActivities-popup-select-option-1"),
            calculateButton = $("[data-type='travelSubmit']");


    public TravelPage() {
        destinationInput.shouldBe(visible.because("Travel Page should be loaded"));
    }

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
                .setValue("India");
        indiaOption
                .shouldBe(visible.because("India Option should be visible"))
                .click();
        appliedCountryOption
                .shouldBe(visible.because("India Option should be visible"))
                .shouldHave(text("India"));
        applyButton
                .shouldBe(visible.because("Apply Button should be visible"))
                .click();
        destinationInput.shouldHave(text("Worldwide"));

        return new TravelPage();
    }

    public TravelPage applyWithHighRiskActivities() {
        activitiesInput
                .shouldBe(visible.because("Activities Input should be visible"))
                .click();
        highRiskOption
                .shouldBe(visible.because("High Risk Button should be visible"))
                .click();
        activitiesInput.shouldHave(text("With High-Risk Activities"));

        return new TravelPage();
    }

    public PolicyPage navigateToPolicyPricingPage() {
        calculateButton
                .shouldBe(visible.because("Calculate Button should be visible"))
                .click();

        return new PolicyPage();
    }
}
