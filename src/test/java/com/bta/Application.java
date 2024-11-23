package com.bta;

import com.bta.utils.Config;
import com.codeborne.selenide.Selenide;



public class Application {

    public static void navigateToHomePage() {
        Selenide.open(Config.getProp("base.url"));
//        return new HomePage();
    }
}
