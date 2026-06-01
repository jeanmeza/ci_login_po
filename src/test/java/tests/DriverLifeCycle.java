package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverLifeCycle {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        var options = new ChromeOptions();
        options.addArguments(
                "--remote-allow-origins=*",
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--headless"
        );
        // declaration and instantiation of objects/variables
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    public void teardown() {
        // close Chrome
        driver.close();
    }
}
