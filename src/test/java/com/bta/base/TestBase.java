package com.bta.base;

import com.bta.utils.Config;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;

public class TestBase {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", Config.getProp("webdriver.chrome.driver"));

        Configuration.timeout = Integer.parseInt(Config.getProp("default.timeout"));
        Configuration.browser = Config.getProp("browser");
        Configuration.baseUrl = Config.getProp("base.url");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
