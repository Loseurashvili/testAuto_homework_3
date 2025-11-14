import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class AlertTests {

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
    public void testAlertWithTextbox() {

        driver.get("https://demo.automationtesting.in/Alerts.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();

        driver.findElement(By.cssSelector("button.btn.btn-info")).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String input = "Loseurashvili Zviad";

        alert.sendKeys(input);
        alert.accept();

        String result = driver.findElement(By.id("demo1")).getText();

        Assert.assertTrue(result.contains(input));
    }
}
