package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FitPeoTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     // Navigate to FitPeo homepage
        driver.get("https://fitpeo.com");
        driver.manage().window().maximize();
    }

    @Test
    public void testRevenueCalculator() {
        

        // Navigate to Revenue Calculator page
        WebElement revenueCalculatorLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/header/div/div[3]/div[6]")));
        revenueCalculatorLink.click();

        // Scroll down to the slider section
        WebElement slider = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div[1]/div[2]/div/div/span[1]/span[3]/input"))); // Update selector as necessary
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", slider);

        // Adjust the slider to 820
        Actions move = new Actions(driver);
        move.dragAndDropBy(slider, 94,0).perform();

        // Ensure the text field updates to 820
        WebElement textField = driver.findElement(By.xpath("//*[@id=\":r0:\"]")); // Update selector as necessary
        wait.until(ExpectedConditions.attributeToBe(textField, "value", "823"));

        // Update the text field to 560
       

         // Validate the slider value
        Assert.assertEquals(textField.getAttribute("value"), "823");
        
     textField.clear();
        textField.sendKeys("560");
    
    

        // Select CPT Codes
        driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
        driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
        driver.findElement(By.xpath("(//input[@type='checkbox'])[8]")).click();
    
    // Validate Total Recurring Reimbursement
        WebElement reimbursementHeader = driver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div/p[4]")); // Update selector as necessary
        wait.until(ExpectedConditions.textToBe(By.xpath("/html/body/div[2]/div[1]/header/div/p[4]"), 
        "Total Recurring Reimbursement for all Patients Per Month: $111105"));
    }
    

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}