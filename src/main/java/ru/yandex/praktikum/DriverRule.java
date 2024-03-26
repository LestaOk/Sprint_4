package ru.yandex.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverRule extends ExternalResource {
    public WebDriver driver;

    @Override
    protected void before() throws Throwable {
        initDriver();
    }

    @Override
    protected void after() {
        driver.quit();
    }

    public void initDriver() {
        if ("firefox".equals(System.getProperty("browser"))) {
            initFirefoxDriver();
        }
        else {
            initChromeDriver();
        }
    }

    private void initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    private void initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
