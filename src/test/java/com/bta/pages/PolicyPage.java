package com.bta.pages;

import com.bta.base.PageBase;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PolicyPage extends PageBase {

    private static final SelenideElement
        continueWithOptimalButton = $("[datatype='selectPolicyPlanOPTIMAL']");

    public PolicyPage() {
        super();
        continueWithOptimalButton.shouldBe(visible.because("Policy Page should be loaded"), Duration.ofMillis(timeout));
    }

    public AdditionalOptionsPage navigateToAdditionalOptionsPage() {
        continueWithOptimalButton.click();

        return new AdditionalOptionsPage();
    }
}
