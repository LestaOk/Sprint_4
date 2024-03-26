package ru.yandex.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.praktikum.Config;
import ru.yandex.praktikum.Utils;

public class MainPage {
    private final WebDriver driver;
    private final By confirmCookieButton = By.id("rcc-confirm-button");
    private final By goButton = By.cssSelector("[class*=Header_Button_]");
    private final By orderInput = By.cssSelector(".Input_Input__1iN_Z");
    private final By statusButton = By.cssSelector(".Header_Link__1TAG7");
    private final By faqSubHeader = By.cssSelector(".Home_FourPart__1uthg .Home_SubHeader__zwi_E");
    private final By topOrderButton = By.cssSelector(".Header_Nav__AGCXC .Button_Button__ra12g");
    private final By lowerOrderButton = By.className("Button_Middle__1CSJM");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderFirstPage clickOrderButton(boolean isTopPosition) {

        if (isTopPosition) {
            driver.findElement(topOrderButton).click();
        }
        else {
            driver.findElement(lowerOrderButton).click();
        }

        return new OrderFirstPage(driver);
    }

    public StatusPage clickGoButton() {
        driver.findElement(goButton).click();
        return new StatusPage(driver);
    }

    public MainPage enterOrder(String orderNumber) {
        Utils.waitElementToBeClickable(driver, orderInput)
                .sendKeys(orderNumber);
        return this;
    }

    public MainPage clickStatusButton() {
        Utils.waitElementToBeClickable(driver, statusButton)
                .click();
        return this;
    }

    public MainPage openBaseLink() {
        driver.get(Config.BASE_URL);
        clickToConfirmCookieButton();
        return this;
    }

    private void clickToConfirmCookieButton() {
        driver.findElement(confirmCookieButton).click();
    }

    public FaqSection scrollTillFaqSection() {
        WebElement element = driver.findElement(faqSubHeader);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return new FaqSection(driver);
    }
}
