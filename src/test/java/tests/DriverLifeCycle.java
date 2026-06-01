package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverLifeCycle {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        // declaration and instantiation of objects/variables
        driver = new ChromeDriver();
    }

    @AfterEach
    public void teardown() {
        // close Chrome
        driver.close();
    }
}
