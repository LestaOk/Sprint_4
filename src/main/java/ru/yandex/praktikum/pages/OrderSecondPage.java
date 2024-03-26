package ru.yandex.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.Utils;
import ru.yandex.praktikum.Constants;

public class OrderSecondPage {
    public OrderSecondPage(WebDriver driver) {
        this.driver = driver;
    }

    private final WebDriver driver;

    private String rentalOptionXpath = "//div[@class='Dropdown-option' and text()='%s']";
    private final By backButton = By.className("Button_Inverted__3IF-i");
    private final By dateInput = By.cssSelector("[placeholder*='Когда']");
    private final By dropdownArrow = By.className("Dropdown-arrow");
    private final By rentalDropdownList = By.className("Dropdown-option");
    private final By checkboxBlack = By.id("black");
    private final By checkboxGrey = By.id("grey");
    private final By commentInput = By.cssSelector("[placeholder*='Комментарий']");
    private final By makeOrderButton = By.xpath("//button[contains(@class, 'Button_Middle__1CSJM') and text() = 'Заказать']");

    public OrderSecondPage fillInDate (String date) {
        driver.findElement(dateInput).sendKeys(date);
        return this;
    }

    public OrderSecondPage fillInRentalPeriod (String selectedOption) {
        String rentalOptionXpath = String.format(this.rentalOptionXpath, selectedOption);
        driver.findElement(dropdownArrow).click();

        Utils.waitElementToBeVisible(driver, rentalDropdownList);
        driver.findElement(By.xpath(rentalOptionXpath)).click();
        return this;
    }

    public OrderSecondPage selectColor (String color) {
        switch (color) {
            case Constants.BLACK:
                driver.findElement(checkboxBlack).click();
                break;
            case Constants.GREY:
            default:
                driver.findElement(checkboxGrey).click();
                break;
        }
        return this;
    }

    public OrderSecondPage addComment(String comment) {
        driver.findElement(commentInput).sendKeys(comment);
        return this;
    }

    public OrderModalPage clickNextButton() {
        driver.findElement(makeOrderButton).click();
        return new OrderModalPage(driver);
    }

    public OrderSecondPage waitTillSecondPageIsLoaded() {
        Utils.waitElementToBeClickable(driver, backButton);
        return this;
    }
}
