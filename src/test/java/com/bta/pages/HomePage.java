package com.bta.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    // No good selector option for this element are present. Should be addressed to the fe team.
//    private static final SelenideElement travelLink = $x("//a[.=' Ceļojumi ']");
    private static final SelenideElement travelLink = $(".quick-menu-btn:nth-child(2)");

    public HomePage() {
        travelLink.shouldBe(visible.because("Home Page should be loaded"));
    }

    public TravelPage navigateToTravelInsurancePage() {
        travelLink.click();
        return new TravelPage();
    }
}
