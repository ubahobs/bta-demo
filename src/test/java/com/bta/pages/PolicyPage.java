package com.bta.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PolicyPage {
//
    private static final SelenideElement
        continueWithOptimalButton = $("[datatype='selectPolicyPlanOPTIMAL']");

    public PolicyPage() {
        continueWithOptimalButton.shouldBe(visible.because("Policy Page should be loaded"));
    }

    public AdditionalOptionsPage navigateToAdditionalOptionsPage() {
        continueWithOptimalButton.click();

        return new AdditionalOptionsPage();
    }
}
