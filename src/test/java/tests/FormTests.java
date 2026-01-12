package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PracticeFormPage;

@Epic("Forms")
@Feature("Practice Form")
public class FormTests extends BaseTest {

    @Test(description = "Verify practice form submission")
    @Story("User submits form successfully")
    @Severity(SeverityLevel.BLOCKER)
    public void testPracticeForm() {

        PracticeFormPage form = new PracticeFormPage(driver);
        form.open();
        form.fillForm();

        String text = form.getModalText();

        Assert.assertTrue(text.contains("Loseurashvili"));
        Assert.assertTrue(text.contains("Zviad"));
        Assert.assertTrue(text.contains("zvio@gmail.com"));
        Assert.assertTrue(text.contains("5555555555"));
        Assert.assertTrue(text.contains("Math"));
        Assert.assertTrue(text.contains("Sports"));
        Assert.assertTrue(text.contains("Tbilisi"));
    }
}
