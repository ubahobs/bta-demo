package com.bta.pages;

import com.bta.base.PageBase;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HomePage extends PageBase {

    private static final SelenideElement
            acceptCookies = $("[tabindex='7']"),
            travelLink = $(".quick-menu-btn:nth-child(2)");

    public HomePage() {
        super();
        if (acceptCookies.exists())
            acceptCookies
                    .shouldBe(visible.because("Accept Cookies Button should be visible"), Duration.ofMillis(timeout))
                    .click();

        travelLink.shouldBe(visible.because("Home Page should be loaded"));
    }

    @Step
    public TravelPage navigateToTravelInsurancePage() {
        travelLink.click();
        return new TravelPage();
    }
}
