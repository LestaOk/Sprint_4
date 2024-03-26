package ru.yandex.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.Utils;

public class StatusPage {
    private final WebDriver driver;
    private final By notFoundImage = By.cssSelector("[alt = 'Not found']");

    public StatusPage(WebDriver driver) {
        this.driver = driver;
    }
    public void checkNotFound() {
        Utils.waitElementToBeVisible(driver, notFoundImage);
        assert driver.findElement(notFoundImage).isDisplayed();
    }
}
