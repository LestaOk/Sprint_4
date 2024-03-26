package ru.yandex.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderModalPage {
    public OrderModalPage(WebDriver driver) {
        this.driver = driver;
    }
    private final String SUCCESSFUL_ORDER_HEADER = "Заказ оформлен";
    private final WebDriver driver;
    private final By yesButton = By.xpath("//button[contains(@class, 'Button_Middle__1CSJM') and text() = 'Да']");
    private final By modalHeader = By.className("Order_ModalHeader__3FDaJ");

    public OrderModalPage clickToYesButton() {
        driver.findElement(yesButton).click();
        return this;
    }

    private String getModalHeader() {
        return driver.findElement(modalHeader).getText();
    }

    public void checkSuccessfulOrderHeader() {
        String header = getModalHeader();
        assert header.startsWith(SUCCESSFUL_ORDER_HEADER);
    }
}
