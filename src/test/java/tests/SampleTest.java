package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest {
    WebDriver driver;
    @BeforeTest
    public void setup() {
        // Setup WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();

        // Configure Chrome options
        ChromeOptions options = new ChromeOptions();
        // Add any additional options here if needed

        // Initialize ChromeDriver
        driver = new ChromeDriver(options);
    }
    @Test
    public void testGoogleSearch() {
        // Navigate to Google
        driver.get("https://www.google.com");

        // Perform search
        driver.findElement(By.name("q")).sendKeys("Selenium");

        // Submit the search
        driver.findElement(By.name("btnK")).submit();

        // Wait for search results
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Assert that the title contains the search term
        Assert.assertTrue(driver.getTitle().contains("Selenium"));
    }

    @Test
    public void testGoogleSearchTwo() {

        Assert.assertTrue(true);
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
