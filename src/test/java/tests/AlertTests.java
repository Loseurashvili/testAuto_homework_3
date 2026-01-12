package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;

@Epic("Alerts")
@Feature("Alert with Textbox")
public class AlertTests extends BaseTest {

    @Test(description = "Verify alert textbox accepts input")
    @Story("User enters text in alert")
    @Severity(SeverityLevel.CRITICAL)
    public void testAlertWithTextbox() {

        AlertsPage alerts = new AlertsPage(driver);
        alerts.open();

        String input = "Loseurashvili Zviad";
        alerts.openTextboxAlert();
        alerts.enterTextAndAccept(input);

        Assert.assertTrue(alerts.getResultText().contains(input));
    }
}
