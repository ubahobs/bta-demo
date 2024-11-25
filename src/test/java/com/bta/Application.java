package com.bta;

import com.bta.pages.HomePage;
import com.bta.utils.Config;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

public class Application {

    @Step
    public static HomePage navigateToHomePage() {
        Selenide.open(Config.getProp("base.url"));
        return new HomePage();
    }
}
