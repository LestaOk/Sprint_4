package ru.yandex.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.Utils;

public class OrderFirstPage {
    private final WebDriver driver;
    private final By firstNameInput = By.cssSelector("[placeholder = '* Имя']");
    private final By lastNameInput = By.cssSelector("[placeholder = '* Фамилия']");
    private final By addressInput = By.cssSelector("[placeholder*='* Адрес']");
    private final By metroStationInput = By.cssSelector("[placeholder*='метро']");
    private final By metroSelectOption = By.className("select-search__option");
    private final By phoneNumberInput = By.cssSelector("[placeholder*='* Телефон']");
    private final By nextButton = By.className("Button_Middle__1CSJM");
    public OrderFirstPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderFirstPage fillInFirstName (String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        return this;
    }

    public OrderFirstPage fillInLastName (String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
        return this;
    }

    public OrderFirstPage fillInAddress (String address) {
        driver.findElement(addressInput).sendKeys(address);
        return this;
    }

    public OrderFirstPage selectMetroStation (String metro) {
        driver.findElement(metroStationInput).sendKeys(metro);
        Utils.waitElementToBeVisible(driver, metroSelectOption).click();
        return this;
    }

    public OrderFirstPage fillInPhoneNumber (String phoneNumber) {
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
        return this;
    }

    public OrderSecondPage clickNextButton() {
        driver.findElement(nextButton).click();
        return new OrderSecondPage(driver);
    }
}
