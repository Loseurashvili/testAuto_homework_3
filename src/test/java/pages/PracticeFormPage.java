package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class PracticeFormPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://demoqa.com/automation-practice-form");
    }

    public void fillForm() {
        driver.findElement(By.id("firstName")).sendKeys("Loseurashvili");
        driver.findElement(By.id("lastName")).sendKeys("Zviad");
        driver.findElement(By.id("userEmail")).sendKeys("zvio@gmail.com");

        driver.findElement(By.cssSelector("label[for='gender-radio-1']")).click();
        driver.findElement(By.id("userNumber")).sendKeys("5555555555");

        WebElement subject = driver.findElement(By.id("subjectsInput"));
        subject.sendKeys("Math");
        subject.sendKeys(Keys.ENTER);

        driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']")).click();
        driver.findElement(By.id("currentAddress")).sendKeys("Tbilisi, Georgia");

        WebElement submit = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
    }

    public String getModalText() {
        WebElement modal = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("modal-content"))
        );
        return modal.getText();
    }
}
