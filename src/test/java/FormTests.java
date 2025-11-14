import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class FormTests {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }

    @Test
    public void testPracticeForm() {

        driver.get("https://demoqa.com/automation-practice-form");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

        WebElement submitBtn = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitBtn);

        WebElement modal = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("modal-content"))
        );

        String modalText = modal.getText();

        Assert.assertTrue(modalText.contains("Loseurashvili"));
        Assert.assertTrue(modalText.contains("Zviad"));
        Assert.assertTrue(modalText.contains("zvio@gmail.com"));
        Assert.assertTrue(modalText.contains("5555555555"));
        Assert.assertTrue(modalText.contains("Math"));
        Assert.assertTrue(modalText.contains("Sports"));
        Assert.assertTrue(modalText.contains("Tbilisi"));
    }
}
