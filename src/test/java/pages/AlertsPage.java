package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class AlertsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://demo.automationtesting.in/Alerts.html");
    }

    public void openTextboxAlert() {
        driver.findElement(By.linkText("Alert with Textbox")).click();
        driver.findElement(By.cssSelector("button.btn-info")).click();
    }

    public void enterTextAndAccept(String text) {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(text);
        alert.accept();
    }

    public String getResultText() {
        return driver.findElement(By.id("demo1")).getText();
    }
}
