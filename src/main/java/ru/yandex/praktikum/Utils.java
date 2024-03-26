package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {
    public static WebElement waitElementToBeVisible(WebDriver driver, By element) {
        return new WebDriverWait(driver, Duration.ofSeconds(Config.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static WebElement waitElementToBeClickable(WebDriver driver, By element) {
        return new WebDriverWait(driver, Duration.ofSeconds(Config.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
