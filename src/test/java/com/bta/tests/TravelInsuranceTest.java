package com.bta.tests;

import com.bta.Application;
import com.bta.base.TestBase;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TravelInsuranceTest extends TestBase {

    @Test
    @Description("Verify user flow for the Travel Insurance")
    public void travelInsuranceTest() {

        Application
                .navigateToHomePage()
                .navigateToTravelInsurancePage()
                .applyWorldwideTravelDestination()
                .applyWithHighRiskActivities()
                .navigateToPolicyPricingPage()
                .navigateToAdditionalOptionsPage()
                .verifyForms()
                .changeInsuranceSum()
                .navigateToTravellerPage()
                .verifyInputsAreEmpty();
    }
}
